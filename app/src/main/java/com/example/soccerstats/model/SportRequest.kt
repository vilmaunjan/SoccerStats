package com.example.soccerstats.model

class SportRequest {

    private val sports: List<Sport>

    constructor(sports: List<Sport>){
        this.sports = sports
    }

    fun getSports(): List<Sport> {
        return sports
    }
}