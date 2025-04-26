package streaming;

import java.util.Scanner;
import java.util.List;
import iterators.SeasonIterator;
import iterators.ReverseSeasonIterator;
import iterators.ShuffleSeasonIterator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many seasons? ");
        int seasonCount = Integer.parseInt(sc.nextLine());
        Series series = new Series();
        for (int i = 1; i <= seasonCount; i++) {
            System.out.print("Season " + i + " - number of episodes: ");
            int epCount = Integer.parseInt(sc.nextLine());
            Season season = new Season();
            for (int j = 1; j <= epCount; j++) {
                System.out.print("Title of episode " + j + ": ");
                String title = sc.nextLine();
                System.out.print("Duration (sec): ");
                int runtime = Integer.parseInt(sc.nextLine());
                season.addEpisode(new Episode(title, runtime));
            }
            series.addSeason(season);
        }

        System.out.print("Mode (1-normal, 2-reverse, 3-shuffle, 4-binge): ");
        int mode = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (mode == 4) {
            EpisodeIterator binge = series.bingeIterator();
            int idx = 1;
            while (binge.hasNext()) {
                Episode e = binge.next();
                System.out.printf("%2d. %s (%ds)%n", idx++, e.getTitle(), e.getRuntimeSec());
            }
        } else {
            List<Season> seasons = series.getSeasons();
            for (int i = 0; i < seasons.size(); i++) {
                Season s = seasons.get(i);
                System.out.println("Season " + (i + 1) + ":");
                EpisodeIterator it = switch (mode) {
                    case 2 -> new ReverseSeasonIterator(s);
                    case 3 -> new ShuffleSeasonIterator(s);
                    default -> new SeasonIterator(s);
                };
                int idx = 1;
                while (it.hasNext()) {
                    Episode e = it.next();
                    System.out.printf(" %2d. %-30s (%4ds)%n", idx++, e.getTitle(), e.getRuntimeSec());
                }
                System.out.println();
            }
        }

        sc.close();
    }
}