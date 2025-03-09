package org.firstinspires.ftc.teamcode.opmode.auto;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.TurnAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.ActionBuilder;
import com.acmerobotics.roadrunner.PoseMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanism;
import org.firstinspires.ftc.teamcode.subsystems.ScoringMechanismPosition;

@Config
@Autonomous(name = "Buckets - Both Alliances", group = "Autonomous")
public class AutoBlueBucketsWithPoseMap extends LinearOpMode {
    // Define field dimensions (standard FTC field is 144 x 144 inches)
    private static final double FIELD_WIDTH = 144.0;

    @Override
    public void runOpMode() {
        // Create the pose map for field mirroring
        PoseMap poseMap = new PoseMap.Builder()
                .add(
                        new Pose2d(0, 0, 0),  // Blue reference (origin)
                        new Pose2d(FIELD_WIDTH, 0, Math.toRadians(180))  // Red reference (mirrored)
                )
                .build();

        // Default alliance
        PoseMap.Alliance alliance = PoseMap.Alliance.BLUE;

        // Blue alliance starting position
        Pose2d blueBeginPose = new Pose2d(32.8, 61, Math.toRadians(-180));

        // Initialize robot hardware
        PinpointDrive drive = new PinpointDrive(hardwareMap, blueBeginPose);
        ScoringMechanism scoringMechanism = new ScoringMechanism(hardwareMap);

        // Alliance selection UI
        boolean lastX = false; // Blue
        boolean lastB = false; // Red

        telemetry.addLine("SELECT ALLIANCE");
        telemetry.addLine("Press X for BLUE");
        telemetry.addLine("Press B for RED");

        while (!isStarted() && !isStopRequested()) {
            boolean currentX = gamepad1.x;
            boolean currentB = gamepad1.b;

            if (currentX && !lastX) {
                alliance = PoseMap.Alliance.BLUE;
                telemetry.addData("Alliance Selected", "BLUE");
            } else if (currentB && !lastB) {
                alliance = PoseMap.Alliance.RED;
                telemetry.addData("Alliance Selected", "RED");
            }

            lastX = currentX;
            lastB = currentB;

            // Show the current start pose based on alliance
            Pose2d startPose = alliance == PoseMap.Alliance.BLUE ?
                    blueBeginPose :
                    poseMap.transform(blueBeginPose, alliance);

            telemetry.addData("Starting Pose", formatPose(startPose));
            telemetry.update();
        }

        waitForStart();

        if (isStopRequested()) return;

        // Get the appropriate starting pose based on alliance
        Pose2d startPose = alliance == PoseMap.Alliance.BLUE ?
                blueBeginPose :
                poseMap.transform(blueBeginPose, alliance);

        // Update the drive's pose estimate for the selected alliance
        drive.setPoseEstimate(startPose);

        telemetry.addData("Running", alliance == PoseMap.Alliance.BLUE ? "BLUE" : "RED");
        telemetry.addData("Start Pose", formatPose(startPose));
        telemetry.update();

        // Create the action sequence for blue alliance
        Action blueAction = drive.actionBuilder(blueBeginPose)
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(0)
                .splineToLinearHeading(new Pose2d(60.5, 54, Math.toRadians(-135)), Math.toRadians(45))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.75)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                    scoringMechanism.horizontalSlide.setTargetPosition(200);
                })
                .setTangent(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(50.8, 38, Math.toRadians(-90)), Math.toRadians(-90))
                .setTangent(0)
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(45))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.75)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                    scoringMechanism.horizontalSlide.setTargetPosition(200);
                })
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(60.5, 38, Math.toRadians(-90)), Math.toRadians(-90))
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(45))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .waitSeconds(0.75)
                .afterTime(0.5, () -> {
                    scoringMechanism.setPosition(ScoringMechanismPosition.INTAKE_ALIGN);
                    scoringMechanism.horizontalSlide.setTargetPosition(200);
                })
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(58.5, 34, Math.toRadians(-45)), -Math.PI/4)
                .afterTime(0.5, () -> scoringMechanism.setPosition(ScoringMechanismPosition.DEPOSIT))
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(60.5, 54.5, Math.toRadians(-135)), Math.toRadians(55))
                .stopAndAdd(() -> scoringMechanism.deposit.openClaw())
                .setTangent(Math.toRadians(225))
                .splineToLinearHeading(new Pose2d(34, 0, Math.toRadians(180)), Math.PI) // park
                .build();

        // Apply the pose map transformation if needed for red alliance
        Action runAction = alliance == PoseMap.Alliance.BLUE ?
                blueAction :
                poseMap.transform(blueAction, alliance);

        // Execute the action
        Actions.runBlocking(runAction);
    }

    // Helper method to format pose for telemetry
    private String formatPose(Pose2d pose) {
        return String.format("x=%.1f, y=%.1f, θ=%.1f°",
                pose.position.x, pose.position.y,
                Math.toDegrees(pose.heading));
    }
}