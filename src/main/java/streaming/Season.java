package streaming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import iterators.SeasonIterator;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    // Сделали геттер публичным
    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public Iterator<Episode> iterator() {
        EpisodeIterator epiIt = new SeasonIterator(this);
        return new Iterator<Episode>() {
            @Override
            public boolean hasNext() {
                return epiIt.hasNext();
            }

            @Override
            public Episode next() {
                return epiIt.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}