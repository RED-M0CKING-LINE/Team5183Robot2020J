package frc.robot.functions;

import frc.robot.RobotMap;

import edu.wpi.first.cameraserver.CameraServer;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;


public class Camera { //TODO MAKE WORK WITH A SECONDARY CAMERA AND USE THREAD FOR SWITCHING CAMERAS. INITALIZE CAMERAS BEFORE THE THREAD

    public void start() {
        new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("Camera0", 0);
            camera.setResolution(720, 480);
            camera.setFPS(RobotMap.cam0FPS);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Camera0", RobotMap.cam0Width, RobotMap.cam0Height);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();
    }
    public void stop() {
        
    }
}