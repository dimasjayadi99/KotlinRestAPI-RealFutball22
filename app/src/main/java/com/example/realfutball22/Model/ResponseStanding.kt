package com.example.realfutball22.Model

data class ResponseStanding(
    val area: Area? = null,
    val season: Season? = null,
    val competition: Competition? = null,
    val filters: Filters? = null,
    val standings: List<StandingsItem?>? = null
)

data class Filters(
    val season: String? = null
)

data class Area(
    val code: String? = null,
    val flag: String? = null,
    val name: String? = null,
    val id: Int? = null
)

data class Season(
    val winner: Any? = null,
    val currentMatchday: Int? = null,
    val endDate: String? = null,
    val id: Int? = null,
    val startDate: String? = null
)

data class TableItem(
    val goalsFor: Int? = null,
    val form: String? = null,
    val lost: Int? = null,
    val won: Int? = null,
    val playedGames: Int? = null,
    val position: Int? = null,
    val team: Team? = null,
    val draw: Int? = null,
    val goalsAgainst: Int? = null,
    val goalDifference: Int? = null,
    val points: Int? = null
)

data class Competition(
    val code: String? = null,
    val name: String? = null,
    val id: Int? = null,
    val type: String? = null,
    val emblem: String? = null
)

data class StandingsItem(
    val stage: String? = null,
    val type: String? = null,
    val table: List<TableItem?>? = null,
    val group: Any? = null
)

data class Team(
    val name: String? = null,
    val tla: String? = null,
    val id: Int? = null,
    val shortName: String? = null,
    val crest: String? = null
)

