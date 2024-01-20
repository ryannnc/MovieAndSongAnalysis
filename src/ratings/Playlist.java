package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {
    private Comparator<Song> compare;

    private BinaryTreeNode<Song> root ;

    public Playlist(Comparator<Song> compare){
        this.compare = compare;
    }

    public void addSong(Song song){
        insert(song);

    }

    public void insert(Song value) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(value, null, null);
        } else {
            this.insertHelper(this.root, value);
        }
    }

    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.compare.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            // ties go right
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }

    public BinaryTreeNode<Song> getSongTree(){
        return this.root;
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> list){
        if (list == null ){
            return null;
        }
        LinkedListNode<Song> left = getSongList(list.getLeft());
        LinkedListNode<Song> current = new LinkedListNode<>(list.getValue(),null);
        LinkedListNode<Song> right = getSongList(list.getRight());

        LinkedListNode<Song> last = left;
        if (last != null){
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(current);
        } else {
            left = current;
        }

        current.setNext(right);

        return left;


    }
    public LinkedListNode<Song> getSongList(){
        return getSongList(this.root);
    }
}
