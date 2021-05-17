package com.cendekia.drakorindoapp.utils

import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.remote.response.DramaResponse

object DataDrama {

    fun generateDummyDrama(): List<DramaEntity> {
        val drama = ArrayList<DramaEntity>()

        drama.add(
            DramaEntity(
                "d01",
                "Start-Up (2020)",
                "Drama, Comedy - 1h 12m",
                "Young entrepreneurs aspiring to launch virtual dreams into reality compete for success and love in the cutthroat world of Korea's high-tech industry.",
                "Park Hye-ryun",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hxJQ3A2wtreuWDnVBbzzXI3YlOE.jpg",
                "https://www.youtube.com/watch?v=Lu3o0XrlsAg"
            )
        )
        drama.add(
            DramaEntity(
                "d02",
                "Korean Pork Belly Rhapsody (2020)",
                "Documentary - 48m",
                "A love letter to pork belly -- a perennial favorite among Koreans of every generation -- unfolds with an exploration of its history and cooking methods.",
                "Kim na Ra",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zp702DFYo0yn22zqxkWrpqHx7Ce.jpg",
                "https://www.youtube.com/watch?v=6HZR56e1ECU"
            )
        )
        drama.add(
            DramaEntity(
                "d03",
                "Miss Korea (2013)",
                "Drama - 1h",
                "This drama takes place in year 1997 and is about a failing cosmetics company that tries to turn a former high school beauty queen into Miss Korea. Oh Ji Young is the former high school beauty queen who has grown up to be nothing more an an elevator girl. Meanwhile, Kim Hyung Joon is an employee of the cosmetics company and will lead the efforts to turn Oh Ji Young into Miss Korea to save his company.",
                "Seo Sook-hyang",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aLXSfjEK76VOkSQkABnNXdycPby.jpg",
                "https://www.youtube.com/watch?v=w-zXK3rLcgM"
            )
        )
        drama.add(
            DramaEntity(
                "d04",
                "Persona (2019)",
                "Drama - 1h",
                "An exploration of different personas in an eclectic collection of four works by critically acclaimed Korean directors.",
                "Yoon Jong-shin",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iS7nWpl8XgidTiQzUpo5RNx4mEr.jpg",
                "https://www.youtube.com/watch?v=y8cUWCGf8jA"
            )
        )
        drama.add(
            DramaEntity(
                "d05",
                "Leverage (2019)",
                "Crime - 1h",
                "There are countless incidents happening in one day. The corruption of the upper class discourages the common people who are living their lives diligently. From immorality to financial fraud, and they even commit a highly developed type of expedient. The victims of corruption are us, the common people. However, we have no choice but to be relieved that the victim is not me at least for this time.",
                "Lee Bo Ra",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xBnKqQUy5NJdJ6fCD0dmiNNFSU6.jpg",
                "https://www.youtube.com/watch?v=Emv0x9Qldx4"
            )
        )
        drama.add(
            DramaEntity(
                "d06",
                "A Korean Odyssey (2017)",
                "Comedy, Mystery - 1h 15m",
                "A self-serving mythical creature's bid for invincibility backfires when he finds himself at the mercy of a woman who can see otherworldly beings.",
                "Min Young Gi",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7AJCemR9KHGEMvtaBVULJWbeodi.jpg",
                "https://www.youtube.com/watch?v=u0m_FAnDDdE"
            )
        )
        drama.add(
            DramaEntity(
                "d07",
                "Live On (2020)",
                "Drama - 1h 10m",
                "Baek Ho-rang is a high school student. Due to her pretty appearance, she is popular on social media and at her school. Yet, Baek Ho-rang only has one friend, due to her condescending personality. Baek Ho-rang encounters a problem. She learns that someone is trying to unveil her secret. To find that anonymous person, Baek Ho-rang joins her high school's broadcasting club. Go Eun-taek is the chief of the broadcasting club. He is a perfectionist and respected by the club members.",
                "Bang Yoo-jung",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dop9lujlpXaIGZImoTgUteHXt7a.jpg",
                "https://www.youtube.com/watch?v=bHfxNo9hk14"
            )
        )
        drama.add(
            DramaEntity(
                "d08",
                "Hush (2020)",
                "Drama - 1h 5m",
                "“Hush” is an office drama about newspaper reporters and their everyday struggles, problems, and ethical dilemmas. Han Jun Hyeok is a veteran reporter for a newspaper. He first became a reporter to pursue justice, but he is now conflicted between idealism and pragmatism. Han Jun Hyeok must also deal with personal issues as a husband and father.",
                "Lee Ji Su",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uQmJt7tVRnojMGi4uKFDO0ako6M.jpg",
                "https://www.youtube.com/watch?v=-EkIssQsM0s"
            )
        )
        drama.add(
            DramaEntity(
                "d09",
                "Suits (2018)",
                "Drama - 1h",
                " legendary lawyer at the top law firm in South Korea. He has charisma and an attractive appearance. He hires Go Yeon Woo as a rookie lawyer for the law firm. Go Yeon Woo has excellent memory.",
                "Choi Kyung Seo ",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x7ds0EcHjhavjIlrJmTvGp43M6n.jpg",
                "https://www.youtube.com/watch?v=zrMSrbfUKpI"
            )
        )
        drama.add(
            DramaEntity(
                "d10",
                "Criminal Minds (2017)",
                "Crime, Drama, Action & Adventure - 1h",
                "Based on the US TV series of the same name, profilers investigate cases from the perspective of the criminals to solve them.",
                "Kim Seok Jin",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hY9QGvObdABYNLYYnA3o9d7uRqV.jpg",
                "https://www.youtube.com/watch?v=fObZcrl6_Z4"
            )
        )
        return drama
    }

    fun generateDummyDramaDetail(dramaId: String): List<DramaEntity> {
        val drama = ArrayList<DramaEntity>()

        drama.add(
            DramaEntity(
                "d01",
                "Start-Up (2020)",
                "Drama, Comedy - 1h 12m",
                "Young entrepreneurs aspiring to launch virtual dreams into reality compete for success and love in the cutthroat world of Korea's high-tech industry.",
                "Park Hye-ryun",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hxJQ3A2wtreuWDnVBbzzXI3YlOE.jpg",
                "https://www.youtube.com/watch?v=Lu3o0XrlsAg"
            )
        )
        drama.add(
            DramaEntity(
                "d02",
                "Korean Pork Belly Rhapsody (2020)",
                "Documentary - 48m",
                "A love letter to pork belly -- a perennial favorite among Koreans of every generation -- unfolds with an exploration of its history and cooking methods.",
                "Kim na Ra",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zp702DFYo0yn22zqxkWrpqHx7Ce.jpg",
                "https://www.youtube.com/watch?v=6HZR56e1ECU"
            )
        )
        drama.add(
            DramaEntity(
                "d03",
                "Miss Korea (2013)",
                "Drama - 1h",
                "This drama takes place in year 1997 and is about a failing cosmetics company that tries to turn a former high school beauty queen into Miss Korea. Oh Ji Young is the former high school beauty queen who has grown up to be nothing more an an elevator girl. Meanwhile, Kim Hyung Joon is an employee of the cosmetics company and will lead the efforts to turn Oh Ji Young into Miss Korea to save his company.",
                "Seo Sook-hyang",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aLXSfjEK76VOkSQkABnNXdycPby.jpg",
                "https://www.youtube.com/watch?v=w-zXK3rLcgM"
            )
        )
        drama.add(
            DramaEntity(
                "d04",
                "Persona (2019)",
                "Drama - 1h",
                "An exploration of different personas in an eclectic collection of four works by critically acclaimed Korean directors.",
                "Yoon Jong-shin",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iS7nWpl8XgidTiQzUpo5RNx4mEr.jpg",
                "https://www.youtube.com/watch?v=y8cUWCGf8jA"
            )
        )
        drama.add(
            DramaEntity(
                "d05",
                "Leverage (2019)",
                "Crime - 1h",
                "There are countless incidents happening in one day. The corruption of the upper class discourages the common people who are living their lives diligently. From immorality to financial fraud, and they even commit a highly developed type of expedient. The victims of corruption are us, the common people. However, we have no choice but to be relieved that the victim is not me at least for this time.",
                "Lee Bo Ra",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xBnKqQUy5NJdJ6fCD0dmiNNFSU6.jpg",
                "https://www.youtube.com/watch?v=Emv0x9Qldx4"
            )
        )
        drama.add(
            DramaEntity(
                "d06",
                "A Korean Odyssey (2017)",
                "Comedy, Mystery - 1h 15m",
                "A self-serving mythical creature's bid for invincibility backfires when he finds himself at the mercy of a woman who can see otherworldly beings.",
                "Min Young Gi",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7AJCemR9KHGEMvtaBVULJWbeodi.jpg",
                "https://www.youtube.com/watch?v=u0m_FAnDDdE"
            )
        )
        drama.add(
            DramaEntity(
                "d07",
                "Live On (2020)",
                "Drama - 1h 10m",
                "Baek Ho-rang is a high school student. Due to her pretty appearance, she is popular on social media and at her school. Yet, Baek Ho-rang only has one friend, due to her condescending personality. Baek Ho-rang encounters a problem. She learns that someone is trying to unveil her secret. To find that anonymous person, Baek Ho-rang joins her high school's broadcasting club. Go Eun-taek is the chief of the broadcasting club. He is a perfectionist and respected by the club members.",
                "Bang Yoo-jung",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dop9lujlpXaIGZImoTgUteHXt7a.jpg",
                "https://www.youtube.com/watch?v=bHfxNo9hk14"
            )
        )
        drama.add(
            DramaEntity(
                "d08",
                "Hush (2020)",
                "Drama - 1h 5m",
                "“Hush” is an office drama about newspaper reporters and their everyday struggles, problems, and ethical dilemmas. Han Jun Hyeok is a veteran reporter for a newspaper. He first became a reporter to pursue justice, but he is now conflicted between idealism and pragmatism. Han Jun Hyeok must also deal with personal issues as a husband and father.",
                "Lee Ji Su",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uQmJt7tVRnojMGi4uKFDO0ako6M.jpg",
                "https://www.youtube.com/watch?v=-EkIssQsM0s"
            )
        )
        drama.add(
            DramaEntity(
                "d09",
                "Suits (2018)",
                "Drama - 1h",
                " legendary lawyer at the top law firm in South Korea. He has charisma and an attractive appearance. He hires Go Yeon Woo as a rookie lawyer for the law firm. Go Yeon Woo has excellent memory.",
                "Choi Kyung Seo ",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x7ds0EcHjhavjIlrJmTvGp43M6n.jpg",
                "https://www.youtube.com/watch?v=zrMSrbfUKpI"
            )
        )
        drama.add(
            DramaEntity(
                "d10",
                "Criminal Minds (2017)",
                "Crime, Drama, Action & Adventure - 1h",
                "Based on the US TV series of the same name, profilers investigate cases from the perspective of the criminals to solve them.",
                "Kim Seok Jin",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hY9QGvObdABYNLYYnA3o9d7uRqV.jpg",
                "https://www.youtube.com/watch?v=fObZcrl6_Z4"
            )
        )
        return drama
    }


    fun generateRemoteDummyDrama(): List<DramaResponse> {
        val drama = ArrayList<DramaResponse>()

        drama.add(
            DramaResponse(
                "d01",
                "Start-Up (2020)",
                "Drama, Comedy - 1h 12m",
                "Young entrepreneurs aspiring to launch virtual dreams into reality compete for success and love in the cutthroat world of Korea's high-tech industry.",
                "Park Hye-ryun",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hxJQ3A2wtreuWDnVBbzzXI3YlOE.jpg",
                "https://www.youtube.com/watch?v=Lu3o0XrlsAg"
            )
        )
        drama.add(
            DramaResponse(
                "d02",
                "Korean Pork Belly Rhapsody (2020)",
                "Documentary - 48m",
                "A love letter to pork belly -- a perennial favorite among Koreans of every generation -- unfolds with an exploration of its history and cooking methods.",
                "Kim na Ra",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zp702DFYo0yn22zqxkWrpqHx7Ce.jpg",
                "https://www.youtube.com/watch?v=6HZR56e1ECU"
            )
        )
        drama.add(
            DramaResponse(
                "d03",
                "Miss Korea (2013)",
                "Drama - 1h",
                "This drama takes place in year 1997 and is about a failing cosmetics company that tries to turn a former high school beauty queen into Miss Korea. Oh Ji Young is the former high school beauty queen who has grown up to be nothing more an an elevator girl. Meanwhile, Kim Hyung Joon is an employee of the cosmetics company and will lead the efforts to turn Oh Ji Young into Miss Korea to save his company.",
                "Seo Sook-hyang",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aLXSfjEK76VOkSQkABnNXdycPby.jpg",
                "https://www.youtube.com/watch?v=w-zXK3rLcgM"
            )
        )
        drama.add(
            DramaResponse(
                "d04",
                "Persona (2019)",
                "Drama - 1h",
                "An exploration of different personas in an eclectic collection of four works by critically acclaimed Korean directors.",
                "Yoon Jong-shin",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iS7nWpl8XgidTiQzUpo5RNx4mEr.jpg",
                "https://www.youtube.com/watch?v=y8cUWCGf8jA"
            )
        )
        drama.add(
            DramaResponse(
                "d05",
                "Leverage (2019)",
                "Crime - 1h",
                "There are countless incidents happening in one day. The corruption of the upper class discourages the common people who are living their lives diligently. From immorality to financial fraud, and they even commit a highly developed type of expedient. The victims of corruption are us, the common people. However, we have no choice but to be relieved that the victim is not me at least for this time.",
                "Lee Bo Ra",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xBnKqQUy5NJdJ6fCD0dmiNNFSU6.jpg",
                "https://www.youtube.com/watch?v=Emv0x9Qldx4"
            )
        )
        drama.add(
            DramaResponse(
                "d06",
                "A Korean Odyssey (2017)",
                "Comedy, Mystery - 1h 15m",
                "A self-serving mythical creature's bid for invincibility backfires when he finds himself at the mercy of a woman who can see otherworldly beings.",
                "Min Young Gi",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7AJCemR9KHGEMvtaBVULJWbeodi.jpg",
                "https://www.youtube.com/watch?v=u0m_FAnDDdE"
            )
        )
        drama.add(
            DramaResponse(
                "d07",
                "Live On (2020)",
                "Drama - 1h 10m",
                "Baek Ho-rang is a high school student. Due to her pretty appearance, she is popular on social media and at her school. Yet, Baek Ho-rang only has one friend, due to her condescending personality. Baek Ho-rang encounters a problem. She learns that someone is trying to unveil her secret. To find that anonymous person, Baek Ho-rang joins her high school's broadcasting club. Go Eun-taek is the chief of the broadcasting club. He is a perfectionist and respected by the club members.",
                "Bang Yoo-jung",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dop9lujlpXaIGZImoTgUteHXt7a.jpg",
                "https://www.youtube.com/watch?v=bHfxNo9hk14"
            )
        )
        drama.add(
            DramaResponse(
                "d08",
                "Hush (2020)",
                "Drama - 1h 5m",
                "“Hush” is an office drama about newspaper reporters and their everyday struggles, problems, and ethical dilemmas. Han Jun Hyeok is a veteran reporter for a newspaper. He first became a reporter to pursue justice, but he is now conflicted between idealism and pragmatism. Han Jun Hyeok must also deal with personal issues as a husband and father.",
                "Lee Ji Su",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uQmJt7tVRnojMGi4uKFDO0ako6M.jpg",
                "https://www.youtube.com/watch?v=-EkIssQsM0s"
            )
        )
        drama.add(
            DramaResponse(
                "d09",
                "Suits (2018)",
                "Drama - 1h",
                " legendary lawyer at the top law firm in South Korea. He has charisma and an attractive appearance. He hires Go Yeon Woo as a rookie lawyer for the law firm. Go Yeon Woo has excellent memory.",
                "Choi Kyung Seo ",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x7ds0EcHjhavjIlrJmTvGp43M6n.jpg",
                "https://www.youtube.com/watch?v=zrMSrbfUKpI"
            )
        )
        drama.add(
            DramaResponse(
                "d10",
                "Criminal Minds (2017)",
                "Crime, Drama, Action & Adventure - 1h",
                "Based on the US TV series of the same name, profilers investigate cases from the perspective of the criminals to solve them.",
                "Kim Seok Jin",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hY9QGvObdABYNLYYnA3o9d7uRqV.jpg",
                "https://www.youtube.com/watch?v=fObZcrl6_Z4"
            )
        )
        return drama
    }

    fun generateDummyDramaWithDetail(drama: DramaEntity, favorited: Boolean): DramaWithDetail {
        drama.favorited = favorited
        return DramaWithDetail(drama, generateDummyDramaDetail(drama.drakorindoId))
    }

}