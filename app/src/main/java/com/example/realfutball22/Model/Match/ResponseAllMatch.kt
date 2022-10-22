package com.example.realfutball22.Model.Match

data class ResponseAllMatch(
	val filters: Filters? = null,
	val matches: List<MatchesItem?>? = null,
	val resultSet: ResultSet? = null
)

data class HalfTime(
	val away: Any? = null,
	val home: Any? = null
)

data class MatchesItem(
	val area: Area? = null,
	val matchday: Int? = null,
	val awayTeam: AwayTeam? = null,
	val competition: Competition? = null,
	val utcDate: String? = null,
	val lastUpdated: String? = null,
	val score: Score? = null,
	val stage: String? = null,
	val odds: Odds? = null,
	val season: Season? = null,
	val homeTeam: HomeTeam? = null,
	val id: Int? = null,
	val referees: List<RefereesItem?>? = null,
	val status: String? = null,
	val group: Any? = null
)

data class Season(
	val winner: Any? = null,
	val currentMatchday: Int? = null,
	val endDate: String? = null,
	val id: Int? = null,
	val startDate: String? = null
)

data class FullTime(
	val away: String? = null,
	val home: String? = null
)

data class RefereesItem(
	val nationality: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val type: String? = null
)

data class Competition(
	val code: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val type: String? = null,
	val emblem: String? = null
)

data class Area(
	val code: String? = null,
	val flag: String? = null,
	val name: String? = null,
	val id: Int? = null
)

data class Filters(
	val competitions: String? = null,
	val limit: Int? = null,
	val permission: String? = null,
	val status: List<String?>? = null
)

data class Score(
	val duration: String? = null,
	val winner: Any? = null,
	val halfTime: HalfTime? = null,
	val fullTime: FullTime? = null
)

data class ResultSet(
	val wins: Int? = null,
	val last: String? = null,
	val count: Int? = null,
	val competitions: String? = null,
	val draws: Int? = null,
	val losses: Int? = null,
	val played: Int? = null,
	val first: String? = null
)

data class HomeTeam(
	val name: String? = null,
	val tla: String? = null,
	val id: Int? = null,
	val shortName: String? = null,
	val crest: String? = null
)

data class AwayTeam(
	val name: String? = null,
	val tla: String? = null,
	val id: Int? = null,
	val shortName: String? = null,
	val crest: String? = null
)

data class Odds(
	val msg: String? = null
)

