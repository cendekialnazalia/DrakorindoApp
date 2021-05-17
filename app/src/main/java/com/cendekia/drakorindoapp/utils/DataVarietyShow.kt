package com.cendekia.drakorindoapp.utils

import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.data.source.remote.response.VarietyResponse

object DataVarietyShow {
    fun generateDummyVarietyShow(): List<VarietyEntity> {
        val variety = ArrayList<VarietyEntity>()

        variety.add(
            VarietyEntity(

                "v01",
                "Men on a Mission (2015)",
                "Reality, Comedy - 1h 20m",
                "Male celebs play make-believe as high schoolers, welcoming star transfer students every week and engaging in battles of witty humor and slapstick.",
                "Kim Hee-chul",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/a1rnHdqAvEm5NUWJ2SRzBY4Hkt5.jpg",
                "https://www.youtube.com/watch?v=AxL-MqMz5-E"
            )
        )
        variety.add(
            VarietyEntity(
                "v02",
                "2 Days and 1 Night (2007)",
                "Comedy, Reality - 1h 30m",
                "2 Days & 1 Night is a South Korean reality-variety show with the motto \"real wild road variety.\" Its main concept is to recommend various places of interest that viewers can visit in South Korea.",
                "Lee Bo Raa",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yFhxy5sd3mu1PseTMsrXFFXy7YG.jpg",
                "https://www.youtube.com/watch?v=t07TLJ6oOyc"
            )
        )
        variety.add(
            VarietyEntity(
                "v03",
                "Grandpas Over Flowers (2013)",
                "Reality - 1h 10m",
                "Grandpas Over Flowers is a South Korean travel-reality show that airs on tvN. It stars four veteran actors in their seventies— Lee Soon-jae, Shin Goo, Park Geun-hyung and Baek Il-seob — as they go on a backpacking tour to overseas travel destinations alongside Lee Seo-jin, an actor in his forties. Grandpas Over Flowers became a cultural phenomenon, receiving high ratings for a Korean cable program and spawning several spin-offs and remakes.",
                "Na Young-seok",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c1dSRn6HDYQMyevxYrPEzPEaqOJ.jpg",
                "https://www.youtube.com/watch?v=czlDdw3pwV4"
            )
        )
        variety.add(
            VarietyEntity(
                "v04",
                "Three Meals in Iceland (2019)",
                "Reality - 5m",
                "We don't have an overview translated in English. Help us expand our database by adding one.",
                "Jon Jeon Kook",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6eht4qzZxj76siOfUrkEw7UFFsM.jpg",
                "https://www.youtube.com/watch?v=WmiPIgjUI3s&list=PLMSwpZOzdqeTwEh-70rF8GiinWY8vqQ6p"
            )
        )
        variety.add(
            VarietyEntity(
                "v05",
                "Youth Over Flowers (2014)",
                "Reality - 1h 30m",
                "Youth Over Flowers is a South Korean travel-reality show which premiered on tvN in 2014.",
                "Kim Bum",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hQQZsjEMsmWbz6z9OfMzj0PSKe1.jpg",
                "https://www.youtube.com/watch?v=gzOPFI9vjX0&list=PLcwtzCSK4GVhf14VmO2AMyLzG_M0iS6zm"
            )
        )
        variety.add(
            VarietyEntity(
                "v06",
                "Three Meals a Day: Fishing Village (2015)",
                "Reality -1h 40m",
                "Three Meals a Day: Fishing Village is a South Korean variety/cooking show in which celebrities live in a rural fishing village. They must catch food for and prepare three meals a day.",
                "Lee Na Na",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qBxRxDnWE3I4FL2pFXD3UavlzEy.jpg",
                "https://www.youtube.com/watch?v=qKuvrvlZjDo&list=PL_gn4-WJG27AjTU9BXzmAi9d2mZl5SweU"
            )
        )
        variety.add(
            VarietyEntity(
                "v07",
                "Kang's Kitchen (2017)",
                "Reality, Talk - 1h 30m",
                "For the first time in history, here comes a restaurant where the owner eats more than customers. In the backdrop of beautiful Jeju Island, amateur chef Ho-dong and members busy themselves with preparing ingredients, cooking, and serving customers. In the middle of the craziness, members learn the incredible satisfaction of seeing the smile on people’s face when they eat your food and make invaluable acquaintances with people from all walks of life.",
                "Kim Taehyung",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c022MTppuVz4mUZRg4jLisLQetB.jpg",
                "https://www.youtube.com/watch?v=Pz1sT0NEGns"
            )
        )
        variety.add(
            VarietyEntity(
                "v08",
                "New Journey to the West (2015)",
                "Drama, Comedy - 1h 40m",
                "Each member takes one of the characters from the classic Chinese novel “Journey to the West” as they go to different destination every season",
                "Namjoon",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qtETUPb0eBnH55ufgRfIianhcvf.jpg",
                "https://www.youtube.com/watch?v=vhumhhwoInA"
            )
        )
        variety.add(
            VarietyEntity(
                "v09",
                "Three Meals a Day: Jeongseon Village (2014)",
                "Reality - 1h 40m",
                "Three Meals a Day is a South Korean reality/cooking show, in which celebrities are chosen to live for three days a week in a rural setting. They are required to use their own means to find food for and prepare three meals a day.",
                "Park Shin Hye",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vou8nrVWsGsn8efmKcA5zEYEVmj.jpg",
                "https://www.youtube.com/watch?v=3zKI2ba2TfE"
            )
        )
        variety.add(
            VarietyEntity(
                "v10",
                "Let's Eat (2013)",
                "Reality - 1h 30m",
                "What do a group of foodies and a murder have in common? Lee Soo Kyung is a 33-year-old divorcee who is a composed, confident woman who is happy to be living alone after marrying way too early in life. But the only thing that can make her lose her cool composure is great food. Living next door is another foodie, Goo Dae Young, a single man who loves surrounding himself with gourmet food but hates being asked if he is dining alone at great restaurants. When a strange murder occurs in their neighborhood, how will their lives be intertwined?",
                "Lim Soo Mi",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9gPf7cNi3Iwg08JKSXoV6Y2liOW.jpg",
                "https://www.youtube.com/watch?v=JufPKsXr5n4"
            )
        )
        return variety
    }

    fun generateDummyVarietyShowDetail(varietyId: String): List<VarietyEntity> {
        val variety = ArrayList<VarietyEntity>()

        variety.add(
            VarietyEntity(

                "v01",
                "Men on a Mission (2015)",
                "Reality, Comedy - 1h 20m",
                "Male celebs play make-believe as high schoolers, welcoming star transfer students every week and engaging in battles of witty humor and slapstick.",
                "Kim Hee-chul",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/a1rnHdqAvEm5NUWJ2SRzBY4Hkt5.jpg",
                "https://www.youtube.com/watch?v=AxL-MqMz5-E"
            )
        )
        variety.add(
            VarietyEntity(
                "v02",
                "2 Days and 1 Night (2007)",
                "Comedy, Reality - 1h 30m",
                "2 Days & 1 Night is a South Korean reality-variety show with the motto \"real wild road variety.\" Its main concept is to recommend various places of interest that viewers can visit in South Korea.",
                "Lee Bo Raa",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yFhxy5sd3mu1PseTMsrXFFXy7YG.jpg",
                "https://www.youtube.com/watch?v=t07TLJ6oOyc"
            )
        )
        variety.add(
            VarietyEntity(
                "v03",
                "Grandpas Over Flowers (2013)",
                "Reality - 1h 10m",
                "Grandpas Over Flowers is a South Korean travel-reality show that airs on tvN. It stars four veteran actors in their seventies— Lee Soon-jae, Shin Goo, Park Geun-hyung and Baek Il-seob — as they go on a backpacking tour to overseas travel destinations alongside Lee Seo-jin, an actor in his forties. Grandpas Over Flowers became a cultural phenomenon, receiving high ratings for a Korean cable program and spawning several spin-offs and remakes.",
                "Na Young-seok",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c1dSRn6HDYQMyevxYrPEzPEaqOJ.jpg",
                "https://www.youtube.com/watch?v=czlDdw3pwV4"
            )
        )
        variety.add(
            VarietyEntity(
                "v04",
                "Three Meals in Iceland (2019)",
                "Reality - 5m",
                "We don't have an overview translated in English. Help us expand our database by adding one.",
                "Jon Jeon Kook",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6eht4qzZxj76siOfUrkEw7UFFsM.jpg",
                "https://www.youtube.com/watch?v=WmiPIgjUI3s&list=PLMSwpZOzdqeTwEh-70rF8GiinWY8vqQ6p"
            )
        )
        variety.add(
            VarietyEntity(
                "v05",
                "Youth Over Flowers (2014)",
                "Reality - 1h 30m",
                "Youth Over Flowers is a South Korean travel-reality show which premiered on tvN in 2014.",
                "Kim Bum",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hQQZsjEMsmWbz6z9OfMzj0PSKe1.jpg",
                "https://www.youtube.com/watch?v=gzOPFI9vjX0&list=PLcwtzCSK4GVhf14VmO2AMyLzG_M0iS6zm"
            )
        )
        variety.add(
            VarietyEntity(
                "v06",
                "Three Meals a Day: Fishing Village (2015)",
                "Reality -1h 40m",
                "Three Meals a Day: Fishing Village is a South Korean variety/cooking show in which celebrities live in a rural fishing village. They must catch food for and prepare three meals a day.",
                "Lee Na Na",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qBxRxDnWE3I4FL2pFXD3UavlzEy.jpg",
                "https://www.youtube.com/watch?v=qKuvrvlZjDo&list=PL_gn4-WJG27AjTU9BXzmAi9d2mZl5SweU"
            )
        )
        variety.add(
            VarietyEntity(
                "v07",
                "Kang's Kitchen (2017)",
                "Reality, Talk - 1h 30m",
                "For the first time in history, here comes a restaurant where the owner eats more than customers. In the backdrop of beautiful Jeju Island, amateur chef Ho-dong and members busy themselves with preparing ingredients, cooking, and serving customers. In the middle of the craziness, members learn the incredible satisfaction of seeing the smile on people’s face when they eat your food and make invaluable acquaintances with people from all walks of life.",
                "Kim Taehyung",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c022MTppuVz4mUZRg4jLisLQetB.jpg",
                "https://www.youtube.com/watch?v=Pz1sT0NEGns"
            )
        )
        variety.add(
            VarietyEntity(
                "v08",
                "New Journey to the West (2015)",
                "Drama, Comedy - 1h 40m",
                "Each member takes one of the characters from the classic Chinese novel “Journey to the West” as they go to different destination every season",
                "Namjoon",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qtETUPb0eBnH55ufgRfIianhcvf.jpg",
                "https://www.youtube.com/watch?v=vhumhhwoInA"
            )
        )
        variety.add(
            VarietyEntity(
                "v09",
                "Three Meals a Day: Jeongseon Village (2014)",
                "Reality - 1h 40m",
                "Three Meals a Day is a South Korean reality/cooking show, in which celebrities are chosen to live for three days a week in a rural setting. They are required to use their own means to find food for and prepare three meals a day.",
                "Park Shin Hye",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vou8nrVWsGsn8efmKcA5zEYEVmj.jpg",
                "https://www.youtube.com/watch?v=3zKI2ba2TfE"
            )
        )
        variety.add(
            VarietyEntity(
                "v10",
                "Let's Eat (2013)",
                "Reality - 1h 30m",
                "What do a group of foodies and a murder have in common? Lee Soo Kyung is a 33-year-old divorcee who is a composed, confident woman who is happy to be living alone after marrying way too early in life. But the only thing that can make her lose her cool composure is great food. Living next door is another foodie, Goo Dae Young, a single man who loves surrounding himself with gourmet food but hates being asked if he is dining alone at great restaurants. When a strange murder occurs in their neighborhood, how will their lives be intertwined?",
                "Lim Soo Mi",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9gPf7cNi3Iwg08JKSXoV6Y2liOW.jpg",
                "https://www.youtube.com/watch?v=JufPKsXr5n4"
            )
        )
        return variety
    }

    fun generateRemoteDummyVarietyShow(): List<VarietyResponse> {
        val variety = ArrayList<VarietyResponse>()

        variety.add(
            VarietyResponse(

                "v01",
                "Men on a Mission (2015)",
                "Reality, Comedy - 1h 20m",
                "Male celebs play make-believe as high schoolers, welcoming star transfer students every week and engaging in battles of witty humor and slapstick.",
                "Kim Hee-chul",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/a1rnHdqAvEm5NUWJ2SRzBY4Hkt5.jpg",
                "https://www.youtube.com/watch?v=AxL-MqMz5-E"
            )
        )
        variety.add(
            VarietyResponse(
                "v02",
                "2 Days and 1 Night (2007)",
                "Comedy, Reality - 1h 30m",
                "2 Days & 1 Night is a South Korean reality-variety show with the motto \"real wild road variety.\" Its main concept is to recommend various places of interest that viewers can visit in South Korea.",
                "Lee Bo Raa",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yFhxy5sd3mu1PseTMsrXFFXy7YG.jpg",
                "https://www.youtube.com/watch?v=t07TLJ6oOyc"
            )
        )
        variety.add(
            VarietyResponse(
                "v03",
                "Grandpas Over Flowers (2013)",
                "Reality - 1h 10m",
                "Grandpas Over Flowers is a South Korean travel-reality show that airs on tvN. It stars four veteran actors in their seventies— Lee Soon-jae, Shin Goo, Park Geun-hyung and Baek Il-seob — as they go on a backpacking tour to overseas travel destinations alongside Lee Seo-jin, an actor in his forties. Grandpas Over Flowers became a cultural phenomenon, receiving high ratings for a Korean cable program and spawning several spin-offs and remakes.",
                "Na Young-seok",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c1dSRn6HDYQMyevxYrPEzPEaqOJ.jpg",
                "https://www.youtube.com/watch?v=czlDdw3pwV4"
            )
        )
        variety.add(
            VarietyResponse(
                "v04",
                "Three Meals in Iceland (2019)",
                "Reality - 5m",
                "We don't have an overview translated in English. Help us expand our database by adding one.",
                "Jon Jeon Kook",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6eht4qzZxj76siOfUrkEw7UFFsM.jpg",
                "https://www.youtube.com/watch?v=WmiPIgjUI3s&list=PLMSwpZOzdqeTwEh-70rF8GiinWY8vqQ6p"
            )
        )
        variety.add(
            VarietyResponse(
                "v05",
                "Youth Over Flowers (2014)",
                "Reality - 1h 30m",
                "Youth Over Flowers is a South Korean travel-reality show which premiered on tvN in 2014.",
                "Kim Bum",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hQQZsjEMsmWbz6z9OfMzj0PSKe1.jpg",
                "https://www.youtube.com/watch?v=gzOPFI9vjX0&list=PLcwtzCSK4GVhf14VmO2AMyLzG_M0iS6zm"
            )
        )
        variety.add(
            VarietyResponse(
                "v06",
                "Three Meals a Day: Fishing Village (2015)",
                "Reality -1h 40m",
                "Three Meals a Day: Fishing Village is a South Korean variety/cooking show in which celebrities live in a rural fishing village. They must catch food for and prepare three meals a day.",
                "Lee Na Na",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qBxRxDnWE3I4FL2pFXD3UavlzEy.jpg",
                "https://www.youtube.com/watch?v=qKuvrvlZjDo&list=PL_gn4-WJG27AjTU9BXzmAi9d2mZl5SweU"
            )
        )
        variety.add(
            VarietyResponse(
                "v07",
                "Kang's Kitchen (2017)",
                "Reality, Talk - 1h 30m",
                "For the first time in history, here comes a restaurant where the owner eats more than customers. In the backdrop of beautiful Jeju Island, amateur chef Ho-dong and members busy themselves with preparing ingredients, cooking, and serving customers. In the middle of the craziness, members learn the incredible satisfaction of seeing the smile on people’s face when they eat your food and make invaluable acquaintances with people from all walks of life.",
                "Kim Taehyung",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c022MTppuVz4mUZRg4jLisLQetB.jpg",
                "https://www.youtube.com/watch?v=Pz1sT0NEGns"
            )
        )
        variety.add(
            VarietyResponse(
                "v08",
                "New Journey to the West (2015)",
                "Drama, Comedy - 1h 40m",
                "Each member takes one of the characters from the classic Chinese novel “Journey to the West” as they go to different destination every season",
                "Namjoon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qtETUPb0eBnH55ufgRfIianhcvf.jpg",
                "https://www.youtube.com/watch?v=vhumhhwoInA"
            )
        )
        variety.add(
            VarietyResponse(
                "v09",
                "Three Meals a Day: Jeongseon Village (2014)",
                "Reality - 1h 40m",
                "Three Meals a Day is a South Korean reality/cooking show, in which celebrities are chosen to live for three days a week in a rural setting. They are required to use their own means to find food for and prepare three meals a day.",
                "Park Shin Hye",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vou8nrVWsGsn8efmKcA5zEYEVmj.jpg",
                "https://www.youtube.com/watch?v=3zKI2ba2TfE"
            )
        )
        variety.add(
            VarietyResponse(
                "v10",
                "Let's Eat (2013)",
                "Reality - 1h 30m",
                "What do a group of foodies and a murder have in common? Lee Soo Kyung is a 33-year-old divorcee who is a composed, confident woman who is happy to be living alone after marrying way too early in life. But the only thing that can make her lose her cool composure is great food. Living next door is another foodie, Goo Dae Young, a single man who loves surrounding himself with gourmet food but hates being asked if he is dining alone at great restaurants. When a strange murder occurs in their neighborhood, how will their lives be intertwined?",
                "Lim Soo Mi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9gPf7cNi3Iwg08JKSXoV6Y2liOW.jpg",
                "https://www.youtube.com/watch?v=JufPKsXr5n4"
            )
        )
        return variety
    }

    fun generateDummyVarietyWithDetail(
        variety: VarietyEntity,
        favorited: Boolean
    ): VarietyWithDetail {
        variety.favorited = favorited
        return VarietyWithDetail(variety, generateDummyVarietyShowDetail(variety.drakorindoId))
    }
}