package iterators;

import streaming.Episode;
import streaming.EpisodeIterator;
import streaming.Season;
import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private final List<Episode> list;
    private int idx = 0;

    public SeasonIterator(Season season) {
        this.list = season.getEpisodes();
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