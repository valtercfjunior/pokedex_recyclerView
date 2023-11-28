package com.vcfj.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vcfj.pokedex.R
import com.vcfj.pokedex.api.PokemonRepository
import com.vcfj.pokedex.domain.Pokemon
import com.vcfj.pokedex.domain.PokemonStat

class MainActivity : AppCompatActivity(), PokemonAdapter.ClickCard {

    lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: PokemonAdapter

    var pokemons = emptyList<Pokemon?>()
    var fragment = PokemonDetailsFragment()


    override fun clickCard(pokemon: Pokemon) {

        val bundle = bundleOf(
            "name" to pokemon.formattedName,
            "height" to pokemon.formattedHeight,
            "weight" to pokemon.formattedWeight,
            "number" to pokemon.formattedNumber,
            "imageUrl" to pokemon.imageUrl,
            "types" to pokemon.types.map { type -> type.name },
            "abilities" to pokemon.abilities.map { ability -> ability.name },
            "stats" to pokemon.stats.map { stat -> stat.value }

        )
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.mainActivity, fragment)
            .addToBackStack(null).commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        if (pokemons.isEmpty()) {
            Thread(Runnable {
                loadPokemons()
            }).start()
        } else {
            loadRecyclerView()
        }


    }


    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons = it.map { pokemonResult ->

                val numberId = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()
                val pokemonsApiResult = PokemonRepository.getPokemon(numberId)

                pokemonsApiResult?.let {
                    Pokemon(
                        pokemonsApiResult.id,
                        pokemonsApiResult.name,
                        pokemonsApiResult.types.map { type ->
                            type.type
                        },
                        pokemonsApiResult.height,
                        pokemonsApiResult.weight,
                        pokemonsApiResult.stats.map { stats -> PokemonStat(stats.stat.name, stats.base_stat) },
                        pokemonsApiResult.abilities.map { ability -> ability.ability },
                    )
                }
            }


            recyclerView.post {
                loadRecyclerView()
            }
        }
    }

    private fun loadRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons, this)
    }

}