l = {
    1967: "DavidBowie",
    1969: "SpaceOddity",
    1970: "TheManWhoSoldTheWorld",
    1971: "HunkyDory",
    1972: "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars",
    1973: ["AladdinSane", "PinUps"],
    1974: "DiamondDogs",
    1975: "YoungAmericans",
    1976: "StationToStation",
    1977: ["Low", "Heroes"],
    1979: "Lodger",
    1980: "ScaryMonstersAndSuperCreeps",
    1983: "LetsDance",
    1984: "Tonight",
    1987: "NeverLetMeDown",
    1993: "BlackTieWhiteNoise",
    1995: "1.Outside",
    1997: "Earthling",
    1999: "Hours",
    2002: "Heathen",
    2003: "Reality",
    2013: "TheNextDay",
    2016: "BlackStar",
}

Q = int(input())
while Q:
    Q -= 1
    S, E = map(int, input().split())
    result = []
    for year in range(S, E + 1):
        if year in l:
            if isinstance(l[year], list):
                for album in l[year]:
                    result.append((year, album))
            else:
                result.append((year, l[year]))
    print(len(result))
    for year, album in result:
        print(year, album)
