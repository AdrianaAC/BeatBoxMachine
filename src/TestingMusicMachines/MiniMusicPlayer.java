package TestingMusicMachines;

import tryingGui.MyDrawPanel;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer {

    static JFrame frame = new JFrame("MTV here");
    static MyDrawPanel drawPanel;

    public static void main(String[] args) {
        MiniMusicPlayer musicPlayer = new MiniMusicPlayer();
        musicPlayer.go();
    }

    public void setUpGui() {

        drawPanel = new MyDrawPanel();
        frame.setContentPane(drawPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(drawPanel, eventsIWant);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int r = 0;
            for (int i = 5; i < 60; i += 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 9, r, 100, i));
                track.add(makeEvent(176, 9, 127, 0, i));
                track.add(makeEvent(128, 9, r, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void controlChange(ShortMessage event) {
        System.out.println("lalala");
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage midiMessage = new ShortMessage();
            midiMessage.setMessage(comd, chan, one, two);
            event = new MidiEvent(midiMessage, tick);
        } catch (Exception ex) {
        }
        return event;
    }
}
