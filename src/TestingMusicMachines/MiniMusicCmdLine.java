package TestingMusicMachines;

import javax.sound.midi.*;

public class MiniMusicCmdLine {

    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();

        if (args.length < 2) {

            System.out.println("You have to input 2 arguments - the instrument and the note ");

        } else {

            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
            mini.play(instrument, note);

        }
    }


    public void play(int instrument, int note) {

        try { //risky methods, let's try it

            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage midiOn = new ShortMessage();
            midiOn.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(midiOn, 1);
            track.add(noteOn);

            ShortMessage midiOff = new ShortMessage();
            midiOff.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(midiOff, 16);
            track.add(noteOff);

            player.setSequence(sequence);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
