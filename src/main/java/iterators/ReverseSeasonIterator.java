package iterators;

import streaming.Episode;
import streaming.EpisodeIterator;
import streaming.Season;
import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private final List<Episode> list;
    private int idx;

    public ReverseSeasonIterator(Season season) {
        this.list = season.getEpisodes();
        this.idx = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return idx >= 0;
    }

    @Override
    public Episode next() {
        return list.get(idx--);
    }
}