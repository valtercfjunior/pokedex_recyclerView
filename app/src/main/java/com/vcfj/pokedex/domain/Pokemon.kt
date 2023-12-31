package com.vcfj.pokedex.domain

data class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>,
    val height: Int,
    val weight: Int,
    val stats: List<PokemonStat>,
    val abilities: List<PokemonAbility>
) {
    val formattedNumber = number.toString().padStart(3, '0')
    val formattedName = name.capitalize()
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${formattedNumber}.png"
    val formattedHeight = height.toString()
    val formattedWeight = weight.toString()
}

