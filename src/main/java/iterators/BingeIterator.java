package iterators;

import streaming.Episode;
import streaming.EpisodeIterator;
import streaming.Season;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BingeIterator implements EpisodeIterator {
    private final Iterator<Season> seasons;
    private EpisodeIterator curr;

    public BingeIterator(Iterator<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public boolean hasNext() {
        while ((curr == null || !curr.hasNext()) && seasons.hasNext()) {
            curr = new SeasonIterator(seasons.next());
        }
        return curr != null && curr.hasNext();
    }

    @Override
    public Episode next() {
        if (!hasNext()) throw new NoSuchElementException();
        return curr.next();
    }
}