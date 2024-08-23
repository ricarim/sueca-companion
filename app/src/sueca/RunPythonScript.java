package sueca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunPythonScript {
    private String cardName;
    private String pythonScriptPath;

    public RunPythonScript(){
        this.cardName = null;
        this.pythonScriptPath = "scripts/detection.py"; 
    }

    public String[] getCardDetected(){
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python3", this.pythonScriptPath);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                this.cardName = line;
            }

            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

            String[] output = this.cardName.split(" "); 
            System.out.println(output[0]);
            return output;

        } catch (Exception e) {
            String[] output = {e.toString(), null};
            return output;
        }
    }
}

