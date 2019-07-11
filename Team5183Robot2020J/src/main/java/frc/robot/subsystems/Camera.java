package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;


public class Camera {
    Thread thread;
    String CameraName;
    int CameraNumber;
    int ResWidth;
    int ResHeight;
    int FPS;
    int Exposure;

    public Camera(String cameraName, int cameraNumber, int width, int height, int fps, int exposure) {
        this.CameraName = cameraName;
        this.CameraNumber = cameraNumber;
        this.ResWidth = width;
        this.ResHeight = height;
        this.FPS = fps;
        this.Exposure = exposure;
    }

    public void initalize() {
        this.thread = new Thread(() -> { //To add image processing, simply call a function based on the camera name condition
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(CameraName, CameraNumber);
            camera.setResolution(ResWidth, ResHeight);
            camera.setFPS(FPS);
            
            CvSink cvSink = CameraServer.getInstance().getVideo(); 
            CvSource outputStream = CameraServer.getInstance().putVideo(CameraName, ResWidth, ResHeight);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        });
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }
}
