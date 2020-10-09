package TestingMusicMachines;

import javax.sound.midi.*;


public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();                 //instantiate a new object type MiniMiniMusicApp
        System.out.println("Anatomy of the message: ");
        System.out.println("(Message Type , Channel , Note , Velocity)");
        System.out.println("Message Type: 144 means NoteOn, 128 means NoteOff ");
        System.out.println("Channel: 'Musician' of the music. 1 - Keyboard 9 - Drummer");
        System.out.println("Note: From 0-127, being 127 the highest note");
        System.out.println("Velocity: How hard and fast the 'key was pressed'. 100 is a good default, 0 wouldnt hear");
        mini.play();                                                    //invoke the method play on object mini
    }

    public void play() {
        try {                                                           // its risky methods coming, so'll have to try them first
            Sequencer player = MidiSystem.getSequencer();               //get a new sequencer
            player.open();                                              //Open the new sequencer

            Sequence sequence = new Sequence(Sequence.PPQ, 4); //using the sequence constructor to make a new sequence

            Track track = sequence.createTrack();                       // "Ask the sequence" for a track (track lives in the sequence, midi data lives in the track)


            ShortMessage midiOne = new ShortMessage();
            midiOne.setMessage(144, 9, 44, 100);
            MidiEvent noteOn = new MidiEvent(midiOne, 0);
            track.add(noteOn);

            ShortMessage midiTwo = new ShortMessage();
            midiTwo.setMessage(128, 9, 44, 100);
            MidiEvent noteOff = new MidiEvent(midiTwo, 16);
            track.add(noteOff);

            player.setSequence(sequence);                               //giving a sequence to the sequencer
            player.start();                                             // "pushing play" - starting the sequencer
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

