package com.nadji.moviecatalogue.utils

import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.data.source.remote.ResultsItem
import com.nadji.moviecatalogue.data.source.remote.response.*

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                337404,
                "Cruella",
                "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                "2021-05-26",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                8.5,
                false,
                "Comedy, Crime"
            ),
            MovieEntity(
                423108,
                "The Conjuring: The Devil Made Me Do It",
                "/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
                "2021-05-25",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                8.1,
                false,
                "Horror, Mystery, Thriller"
            ),
            MovieEntity(
                637649,
                "Wrath of Man",
                "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                "2021-04-22",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                7.8,
                false,
                "Crime, Action"
            ),
            MovieEntity(
                632357,
                "The Unholy",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                "2021-03-31",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                7.0,
                false,
                "Horror"
            ),
            MovieEntity(
                817451,
                "Endangered Species",
                "/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg",
                "2021-05-27",
                "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
                6.6,
                false,
                "Thriller, Action"
            ),
            MovieEntity(
                602734,
                "Spiral: From the Book of Saw",
                "/lcyKve7nXRFgRyms9M1bndNkKOx.jpg",
                "2021-05-12",
                "Working in the shadow of an esteemed police veteran, brash Detective Ezekiel “Zeke” Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city’s gruesome past.  Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer’s morbid game.",
                6.4,
                false,
                "Mystery, Thriller, Horror"
            ),
            MovieEntity(
                503736,
                "Army of the Dead",
                "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "2021-05-14",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                6.5,
                false,
                "Action, Crime, Science Fiction, Horror, Thriller"
            ),
            MovieEntity(
                460465,
                "Mortal Kombat",
                "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "2021-04-07",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                7.5,
                false,
                "Action, Fantasy, Adventure"
            ),
            MovieEntity(
                399566,
                "Godzilla vs. Kong",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                8.0,
                false,
                "Fantasy, Adventure, Action"
            ),
            MovieEntity(
                520763,
                "A Quiet Place Part II",
                "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "2021-05-21",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                7.3,
                false,
                "Science Fiction, Thriller, Horror"
            ),
            MovieEntity(
                567189,
                "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "2021-04-29",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                7.2,
                false,
                "Action, Thriller, War\n"
            ),
            MovieEntity(
                578701,
                "Those Who Wish Me Dead",
                "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "2021-05-05",
                "A young boy finds himself pursued by two assassins in the Montana wilderness, with a survival expert determined to protect him, and a forest fire threatening to consume them all.",
                7.0,
                false,
                "Thriller, Drama, Action, Mystery"
            )

        )
    }

    fun getdetailMovie(): MovieEntity {
        return MovieEntity(
            337404,
            "Cruella",
            "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
            "2021-05-26",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            8.5,
            false,
            "Comedy, Crime"
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                84958,
                "Loki",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "2021-06-09",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                8.1,
                false,
                "Drama, Sci-Fi & Fantasy"
            ),
            TvShowEntity(
                63174,
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                8.5,
                false,
                "Crime, Sci-Fi & Fantasy"
            ),
            TvShowEntity(
                60735,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                7.7,
                false,
                "Drama, Sci-Fi & Fantasy\n"
            ),
            TvShowEntity(
                103768,
                "Sweet Tooth",
                "/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                "2021-06-04",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                8.0,
                false,
                "Drama, Sci-Fi & Fantasy"
            ),
            TvShowEntity(
                71712,
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                8.6,
                false,
                "Drama"
            ),
            TvShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                7.8,
                false,
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics"
            ),
            TvShowEntity(
                91557,
                "Ragnarok",
                "/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                "2021-06-17",
                "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
                9.0,
                false,
                "Drama, Sci-Fi & Fantasy, Mystery"
            ),
            TvShowEntity(
                1416,
                "Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "2005-03-27",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.2,
                false,
                "Drama"
            ),
            TvShowEntity(
                95057,
                "Superman & Lois",
                "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "2021-02-23",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                8.3,
                false,
                "Sci-Fi & Fantasy, Action & Adventure, Drama"
            ),
            TvShowEntity(
                69050,
                "Riverdale",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "2017-01-26",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                8.6,
                false,
                "Mystery, Drama, Crime"
            ),
            TvShowEntity(
                79460,
                "Legacies",
                "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                "2018-10-25",
                "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                8.6,
                false,
                "Sci-Fi & Fantasy, Drama"
            ),
            TvShowEntity(
                79460,
                "Legacies",
                "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                "2018-10-25",
                "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                8.6,
                false,
                "Sci-Fi & Fantasy, Drama"
            )

        )
    }

    fun getdetailTvShow(): TvShowEntity {
        return TvShowEntity(
            114868,
            "Record of Ragnarok",
            "/iq5L971DFW1SwLJdvl7OpPI1QeZ.jpg",
            "2021-06-17",
            "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
            8.9,
            false,
            "Animation, Action & Adventure, Sci-Fi & Fantasy"
        )
    }

    fun getTrailerMovie(): TrailerEntity {
        return TrailerEntity(
            337404,
            "gmRKv7n2If8"
        )
    }

    fun getTrailerTv(): TrailerEntity {
        return TrailerEntity(
            84958,
            "G4JuopziR3Q"
        )
    }


    fun getRemoteMovies(): List<ResultsItem> {
        return listOf(
            ResultsItem(
                id = 337404,
                title = "Cruella",
                posterPath = "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                release_date = "2021-05-26",
                overview = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                vote_average = 8.5
            ),
            ResultsItem(
                id = 423108,
                title = "The Conjuring: The Devil Made Me Do It",
                posterPath = "/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
                release_date = "2021-05-25",
                overview = "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                vote_average = 8.1,
            ),
            ResultsItem(
                id = 637649,
                title = "Wrath of Man",
                posterPath = "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                release_date = "2021-04-22",
                overview = "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                vote_average = 7.8,
            ),
            ResultsItem(
                id = 632357,
                title = "The Unholy",
                posterPath = "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                release_date = "2021-03-31",
                overview = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                vote_average = 7.0
            ),
            ResultsItem(
                id = 817451,
                title = "Endangered Species",
                posterPath = "/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg",
                release_date = "2021-05-27",
                overview = "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
                vote_average = 6.6
            ),
            ResultsItem(
                id = 602734,
                title = "Spiral: From the Book of Saw",
                posterPath = "/lcyKve7nXRFgRyms9M1bndNkKOx.jpg",
                release_date = "2021-05-12",
                overview = "Working in the shadow of an esteemed police veteran, brash Detective Ezekiel “Zeke” Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city’s gruesome past.  Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer’s morbid game.",
                vote_average = 6.4
            ),
            ResultsItem(
                id = 503736,
                title = "Army of the Dead",
                posterPath = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                release_date = "2021-05-14",
                overview = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                vote_average = 6.5,
            ),
            ResultsItem(
                id = 460465,
                title = "Mortal Kombat",
                posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                release_date = "2021-04-07",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                vote_average = 7.5
            ),
            ResultsItem(
                id = 399566,
                title = "Godzilla vs. Kong",
                posterPath = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                release_date = "2021-03-24",
                overview = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                vote_average = 8.0
            ),
            ResultsItem(
                id = 520763,
                title = "A Quiet Place Part II",
                posterPath = "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                release_date = "2021-05-21",
                overview = "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                vote_average = 7.3
            ),
            ResultsItem(
                id = 567189,
                title = "Tom Clancy's Without Remorse",
                posterPath = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                release_date = "2021-04-29",
                overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                vote_average = 7.2
            ),
            ResultsItem(
                id = 578701,
                title = "Those Who Wish Me Dead",
                posterPath = "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                release_date = "2021-05-05",
                overview = "A young boy finds himself pursued by two assassins in the Montana wilderness, with a survival expert determined to protect him, and a forest fire threatening to consume them all.",
                vote_average = 7.0
            )
        )
    }

    fun getRemoteTvShow(): List<ResultsTvItem> {
        return listOf(
            ResultsTvItem(
                id = 84958,
                name = "Loki",
                posterPath = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                first_air_date = "2021-06-09",
                overview = "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                vote_average = 8.1
            ),
            ResultsTvItem(
                id = 63174,
                name = "Lucifer",
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                first_air_date = "2016-01-25",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                vote_average = 8.5
            ),
            ResultsTvItem(
                id = 60735,
                name = "The Flash",
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                first_air_date = "2014-10-07",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                vote_average = 7.7
            ),
            ResultsTvItem(
                id = 103768,
                name = "Sweet Tooth",
                posterPath = "/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                first_air_date = "2021-06-04",
                overview = "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                vote_average = 8.0
            ),
            ResultsTvItem(
                id = 71712,
                name = "The Good Doctor",
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                first_air_date = "2017-09-25",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                vote_average = 8.6
            ),
            ResultsTvItem(
                id = 88396,
                name = "The Falcon and the Winter Soldier",
                posterPath = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                first_air_date = "2021-03-19",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                vote_average = 7.8
            ),
            ResultsTvItem(
                id = 91557,
                name = "Ragnarok",
                posterPath = "/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                first_air_date = "2021-06-17",
                overview = "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
                vote_average = 9.0
            ),
            ResultsTvItem(
                id = 1416,
                name = "Grey's Anatomy",
                posterPath = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                first_air_date = "2005-03-27",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                vote_average = 8.2
            ),
            ResultsTvItem(
                id = 95057,
                name = "Superman & Lois",
                posterPath = "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                first_air_date = "2021-02-23",
                overview = "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                vote_average = 8.3
            ),
            ResultsTvItem(
                id = 69050,
                name = "Riverdale",
                posterPath = "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                first_air_date = "2017-01-26",
                overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                vote_average = 8.6
            ),
            ResultsTvItem(
                id = 79460,
                name = "Legacies",
                posterPath = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                first_air_date = "2018-10-25",
                overview = "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                vote_average = 8.6
            ),
            ResultsTvItem(
                id = 79460,
                name = "Legacies",
                posterPath = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                first_air_date = "2018-10-25",
                overview = "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                vote_average = 8.6
            ),
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            title = "Cruella",
            posterPath = "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
            release_date = "2021-05-26",
            overview = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            genres = listOf(
                GenresItem(
                    name = "Comedy",
                    id = 35
                ),
                GenresItem(
                    name = "Crime",
                    id = 80
                )
            ),
            vote_average = 8.5,
        )
    }

    fun getRemoteDetailTvShow(): TvDetailResponse {
        return TvDetailResponse(
            name = "Record of Ragnarok",
            posterPath = "/iq5L971DFW1SwLJdvl7OpPI1QeZ.jpg",
            firstAirDate = "2021-06-17",
            overview = "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
            genres = listOf(
                GenresTvItem(
                    name = "Animation",
                    id = 16
                ),
                GenresTvItem(
                    name = "Action & Adventure",
                    id = 10759
                ),
                GenresTvItem(
                    name = "Sci-Fi & Fantasy",
                    id = 10765
                )
            ),
            vote_average = 8.9,
        )
    }
}
