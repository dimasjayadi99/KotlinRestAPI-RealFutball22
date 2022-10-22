package com.example.realfutball22.Model.Squad

data class ResponseSquad(
	val area: Area? = null,
	val venue: String? = null,
	val website: String? = null,
	val address: String? = null,
	val tla: String? = null,
	val founded: Int? = null,
	val runningCompetitions: List<RunningCompetitionsItem?>? = null,
	val clubColors: String? = null,
	val squad: List<SquadItem?>? = null,
	val name: String? = null,
	val id: Int? = null,
	val shortName: String? = null,
	val coach: Coach? = null,
	val crest: String? = null
)

data class RunningCompetitionsItem(
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

data class SquadItem(
	val nationality: String? = null,
	val name: String? = null,
	val dateOfBirth: String? = null,
	val id: Int? = null,
	val position: String? = null
)

data class Coach(
	val firstName: String? = null,
	val lastName: String? = null,
	val nationality: String? = null,
	val contract: Contract? = null,
	val name: String? = null,
	val dateOfBirth: String? = null,
	val id: Int? = null
)

data class Contract(
	val start: Any? = null,
	val until: Any? = null
)

