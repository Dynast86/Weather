package com.dynast.weather.extension.util

sealed class WindDirections(
    val cardinalPoint: String,
    val abbreviation: String
) {
    object N : WindDirections(cardinalPoint = "North", abbreviation = "N")
    object NbE : WindDirections(cardinalPoint = "North by East", abbreviation = "NbE")
    object NNE : WindDirections(cardinalPoint = "North-Northeast", abbreviation = "NNE")
    object NEbN : WindDirections(cardinalPoint = "Northeast by North", abbreviation = "NEbN")
    object NE : WindDirections(cardinalPoint = "Northeast", abbreviation = "NE")
    object NEbE : WindDirections(cardinalPoint = "Northeast by East", abbreviation = "NEbE")
    object ENE : WindDirections(cardinalPoint = "East-Northeast", abbreviation = "ENE")
    object EbN : WindDirections(cardinalPoint = "East by North", abbreviation = "EbN")

    object E : WindDirections(cardinalPoint = "East", abbreviation = "E")
    object EbS : WindDirections(cardinalPoint = "East by South", abbreviation = "EbS")
    object ESE : WindDirections(cardinalPoint = "East-Southeast", abbreviation = "ESE")
    object SEbE : WindDirections(cardinalPoint = "Southeast by East", abbreviation = "SEbE")
    object SE : WindDirections(cardinalPoint = "Southeast", abbreviation = "SE")
    object SEbS : WindDirections(cardinalPoint = "Southeast by South", abbreviation = "SEbS")
    object SSE : WindDirections(cardinalPoint = "South-Southeast", abbreviation = "SSE")
    object SbE : WindDirections(cardinalPoint = "South by East", abbreviation = "SbE")

    object S : WindDirections(cardinalPoint = "South", abbreviation = "S")
    object SbW : WindDirections(cardinalPoint = "South by West", abbreviation = "SbW")
    object SSW : WindDirections(cardinalPoint = "South-Southwest", abbreviation = "SSW")
    object SWbS : WindDirections(cardinalPoint = "Southwest by South", abbreviation = "SWbS")
    object SW : WindDirections(cardinalPoint = "Southwest", abbreviation = "SW")
    object SWbW : WindDirections(cardinalPoint = "Southwest by West", abbreviation = "SWbW")
    object WSW : WindDirections(cardinalPoint = "West-Southwest", abbreviation = "WSW")
    object WbS : WindDirections(cardinalPoint = "West by South", abbreviation = "WbS")

    object W : WindDirections(cardinalPoint = "West", abbreviation = "W")
    object WbN : WindDirections(cardinalPoint = "West by North", abbreviation = "WbN")
    object WNW : WindDirections(cardinalPoint = "West-Northwest", abbreviation = "WNW")
    object NWbW : WindDirections(cardinalPoint = "Northwest by West", abbreviation = "NWbW")
    object NW : WindDirections(cardinalPoint = "Northwest", abbreviation = "NW")
    object NWbN : WindDirections(cardinalPoint = "Northwest by North", abbreviation = "NWbN")
    object NNW : WindDirections(cardinalPoint = "North-Northwest", abbreviation = "NNW")
    object NbW : WindDirections(cardinalPoint = "North by West", abbreviation = "NbW")
}
