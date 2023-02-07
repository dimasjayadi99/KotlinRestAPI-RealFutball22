package com.example.realfutball22.Model.Group

data class ResponseGroupStage(
	val area: Area? = null,
	val season: Season? = null,
	val competition: Competition? = null,
	val filters: Filters? = null,
	val standings: List<StandingsItem?>? = null
)

data class Competition(
	val code: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val type: String? = null,
	val emblem: String? = null
)

data class Season(
	val winner: Any? = null,
	val currentMatchday: Int? = null,
	val endDate: String? = null,
	val id: Int? = null,
	val startDate: String? = null
)

data class Area(
	val code: String? = null,
	val flag: String? = null,
	val name: String? = null,
	val id: Int? = null
)

data class TableItem(
	val goalsFor: Int? = null,
	val form: Any? = null,
	val lost: String? = null,
	val won: String? = null,
	val playedGames: Int? = null,
	val position: String? = null,
	val team: Team? = null,
	val draw: String? = null,
	val goalsAgainst: Int? = null,
	val goalDifference: Int? = null,
	val points: Int? = null
)

data class Filters(
	val season: String? = null
)

data class StandingsItem(
	val stage: String? = null,
	val type: String? = null,
	val table: List<TableItem?>? = null,
	val group: String? = null
)

data class Team(
	val name: String? = null,
	val tla: String? = null,
	val id: Int? = null,
	val shortName: String? = null,
	val crest: String? = null
)

