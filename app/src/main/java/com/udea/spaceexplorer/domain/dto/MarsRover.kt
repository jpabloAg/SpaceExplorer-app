package com.udea.spaceexplorer.domain.dto

data class MarsRover(
    val camera: Camera,
    val earth_date: String,
    val id: Int,
    val img_src: String,
    val rover: Rover,
    val sol: Int
)