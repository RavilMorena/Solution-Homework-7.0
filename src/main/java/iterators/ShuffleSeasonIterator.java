package iterators;

import streaming.Episode;
import streaming.EpisodeIterator;
import streaming.Season;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> list;
    private int idx = 0;

    public ShuffleSeasonIterator(Season season) {
        this.list = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(this.list, new Random(12345));
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }

    @Override
    public Episode next() {
        return list.get(idx++);
    }
}