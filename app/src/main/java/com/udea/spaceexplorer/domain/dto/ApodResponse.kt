package com.udea.spaceexplorer.domain.dto

data class ApodResponse(
    val title: String,
    val url: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String
)

var Selected = ApodResponse("","","","","","","")
