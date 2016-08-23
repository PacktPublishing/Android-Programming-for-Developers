package com.plattysoft.yass;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;

import com.plattysoft.yass.engine.BaseCustomDialog;
import com.plattysoft.yass.sound.SoundManager;

/**
 * Created by Raul Portales on 16/04/15.
 */
public class PauseDialog extends BaseCustomDialog implements View.OnClickListener {

    private PauseDialogListener mListener;
    private int mSelectedId;

    public PauseDialog(YassActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_pause);
        findViewById(R.id.btn_music).setOnClickListener(this);
        findViewById(R.id.btn_sound).setOnClickListener(this);
        findViewById(R.id.btn_exit).setOnClickListener(this);
        findViewById(R.id.btn_resume).setOnClickListener(this);
        updateSoundAndMusicButtons();
    }

    private void updateSoundAndMusicButtons() {
        SoundManager soundManager = mParent.getSoundManager();
        boolean music = soundManager.getMusicStatus();
        ImageView btnMusic = (ImageView) findViewById(R.id.btn_music);
        if (music) {
            btnMusic.setImageResource(R.drawable.music_on_no_bg);
        }
        else {
            btnMusic.setImageResource(R.drawable.music_off_no_bg);
        }
        boolean sound = soundManager.getSoundStatus();
        ImageView btnSounds= (ImageView) findViewById(R.id.btn_sound);
        if (sound) {
            btnSounds.setImageResource(R.drawable.sounds_on_no_bg);
        }
        else {
            btnSounds.setImageResource(R.drawable.sounds_off_no_bg);
        }
    }

    public void setListener(PauseDialogListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sound) {
            mParent.getSoundManager().toggleSoundStatus();
            updateSoundAndMusicButtons();
        }
        else if (v.getId() == R.id.btn_music) {
            mParent.getSoundManager().toggleMusicStatus();
            updateSoundAndMusicButtons();
        }
        else if (v.getId() == R.id.btn_exit) {
            mSelectedId = v.getId();
            super.dismiss();
        }
        else if (v.getId() == R.id.btn_resume) {
            mSelectedId = v.getId();
            super.dismiss();
        }
    }

    @Override
    protected void onDismissed () {
        if (mSelectedId == R.id.btn_exit) {
            mListener.exitGame();
        }
        else if (mSelectedId == R.id.btn_resume) {
            mListener.resumeGame();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mSelectedId = R.id.btn_resume;
    }

    public interface PauseDialogListener {

        void exitGame();

        void resumeGame();
    }
}
