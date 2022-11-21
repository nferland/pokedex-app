package com.example.pokedex_app.data.api.dto.pokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)