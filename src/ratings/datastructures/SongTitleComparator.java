package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song song, Song lift) {
        String title = song.getTitle();
        String title2 = lift.getTitle();
        if (title.compareToIgnoreCase(title2) < 0){
            return true;
        } else {
            return false;
        }
    }
}
