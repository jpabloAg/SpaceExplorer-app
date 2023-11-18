package com.udea.spaceexplorer.domain.dto

data class ISSPosition(
    val iss_position: ISSPositionX,
    val message: String,
    val timestamp: Int
)