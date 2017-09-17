package com.hoobleooble.onedayatatime.Utilities;

import java.util.HashMap;

/**
 * Created by HeatherRobyn on 2017-09-17.
 */

public class RatingConverter {

    public enum ratingType{
        sleep,
        interaction,
        meal,
        day
    }

    public static String convert(int Rating, ratingType type){
        switch (type){
            case day:
                switch (Rating){
                    case 1:
                        return "a very bad day";
                    case 2:
                        return "a bad day";
                    case 3:
                        return "a fairly bad day";
                    case 4:
                        return "a moderately bad day";
                    case 5:
                        return "an average day";
                    case 6:
                        return "a moderately good day";
                    case 7:
                        return "a fairly good day";
                    case 8:
                        return "a good day";
                    case 9:
                        return "a great day";
                    case 10:
                        return "an awesome day";
                    default:
                        return "a good day";
                }

            case meal:

                switch (Rating){
                    case 1:
                        return "very unhealthily";
                    case 2:
                        return "unhealthily";
                    case 3:
                        return "fairly unhealthily";
                    case 4:
                        return "moderately unhealthily";
                    case 5:
                        return "neither healthily nor unhealthily";
                    case 6:
                        return "moderately healthily";
                    case 7:
                        return "fairly healthily";
                    case 8:
                        return "healthily";
                    case 9:
                        return "healthily";
                    case 10:
                        return "very healthily";
                    default:
                        return "nothing";
                }

            case sleep:

                switch (Rating){
                    case 1:
                        return "nowhere near enough sleep";
                    case 2:
                        return "barely any sleep";
                    case 3:
                        return "very little sleep";
                    case 4:
                        return "little sleep";
                    case 5:
                        return "fairly little sleep";
                    case 6:
                        return "not quite enough sleep";
                    case 7:
                        return "almost enough sleep";
                    case 8:
                        return "a full 8 hours of sleep";
                    case 9:
                        return "more than enough sleep";
                    case 10:
                        return "more than enough sleep";
                    default:
                        return "some sleep";
                }

            case interaction:
                switch (Rating){
                    case 1:
                        return "a truly horrible time";
                    case 2:
                        return "a very unenjoyable time";
                    case 3:
                        return "an unenjoyable time";
                    case 4:
                        return "a somewhat unenjoyable time";
                    case 5:
                        return "an average time";
                    case 6:
                        return "a pretty good time";
                    case 7:
                        return "a good time";
                    case 8:
                        return "a very good time";
                    case 9:
                        return "a great time";
                    case 10:
                        return "an amazing time";
                    default:
                        return "a good time";
                }
        }
    return "";
    }
}
