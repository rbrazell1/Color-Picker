package edu.cnm.deepdive.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.colorpicker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private static final int MIN_S = 0;
  private static final int MAX_S = 255;
  private static final int PRESET_S = 150;
  private static final int PRESET_COLOR = Color.YELLOW;
  private static final String RED_FORMAT = "Red: %d";
  private static final String GREEN_FORMAT = "Green: %d";
  private static final String BLUE_FORMAT = "Blue: %d";
  private static final String ALPHA_FORMAT = "Alpha: %d";
  private static final String HEX_FORMAT = "Hex: # ";
  private int redValInt;
  private int greenValInt;
  private int blueValInt;
  private int alphaValInt;

  private ActivityMainBinding binding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);
    setContentView(binding.getRoot());
    binding.colorDisplay.setBackgroundColor(PRESET_COLOR);
    redSeekbar();
    greenSeekbar();
    blueSeekbar();
    alphaSeekbar();
    findColor();
  }

  private void findColor() {
    int r = Color.red(redValInt);
    int g = Color.green(greenValInt);
    int b = Color.blue(blueValInt);
    int a = Color.alpha(alphaValInt);
    String hex = Integer.toHexString(a) + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
    binding.displayValue.setText(String.format(HEX_FORMAT ,a + r + g + b));

  }

  private void redSeekbar() {
    SeekBar seekBar = binding.redBar;
    seekBar.setMin(MIN_S);
    seekBar.setMax(MAX_S);
    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.redVal.setText(String.format(RED_FORMAT, progress));
        redValInt = progress;
        binding.colorDisplay.setBackgroundColor(Color.argb(alphaValInt, redValInt, greenValInt, blueValInt));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
    seekBar.setProgress(PRESET_S);
  }

  private void greenSeekbar() {
    SeekBar seekBar = binding.greenBar;
    seekBar.setMin(MIN_S);
    seekBar.setMax(MAX_S);
    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.greenVal.setText(String.format(GREEN_FORMAT, progress));
        greenValInt = progress;
        binding.colorDisplay.setBackgroundColor(Color.argb(alphaValInt, redValInt, greenValInt, blueValInt));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
    seekBar.setProgress(PRESET_S);
  }

  private void blueSeekbar() {
    SeekBar seekBar = binding.blueBar;
    seekBar.setMin(MIN_S);
    seekBar.setMax(MAX_S);
    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.blueVal.setText(String.format(BLUE_FORMAT, progress));
        blueValInt = progress;
        binding.colorDisplay.setBackgroundColor(Color.argb(alphaValInt, redValInt, greenValInt, blueValInt));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
    seekBar.setProgress(PRESET_S);
  }

  private void alphaSeekbar() {
    SeekBar seekBar = binding.alphaBar;
    seekBar.setMin(MIN_S);
    seekBar.setMax(MAX_S);
    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.alphaVal.setText(String.format(ALPHA_FORMAT, progress));
        alphaValInt = progress;
        binding.colorDisplay.setBackgroundColor(Color.argb(alphaValInt, redValInt, greenValInt, blueValInt));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
    seekBar.setProgress(PRESET_S);
  }

}