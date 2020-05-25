package android.bignerdranch.gamefortheages;

import android.content.Context;

public interface CommunicationFragmentAndActivity {


    public void MailFromFragment(int numberOfFragment);
    void setMusic(int number,boolean musicOnOff, int name,int duration, boolean looping);

    boolean playingMusic(int number);

}
