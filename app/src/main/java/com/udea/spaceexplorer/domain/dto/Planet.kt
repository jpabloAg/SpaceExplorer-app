package com.udea.spaceexplorer.domain.dto

data class Planet(
    val distance_light_year: Double,
    val host_star_mass: Double,
    val host_star_temperature: Double,
    val mass: Double,
    val name: String,
    val period: Double,
    val radius: Double,
    val semi_major_axis: Double,
    val temperature: Double
)