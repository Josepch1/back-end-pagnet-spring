package josehomenhuck.backend.service;

import java.nio.file.Path;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CnabService {
  private final Path fileStorageLocation;
  private final JobLauncher jobLauncher;
  private final Job job;

  public CnabService(@Value("${file.upload-dir}") String fileUploadDir, 
                      @Qualifier("jobLauncherAsync") JobLauncher jobLauncher, 
                      Job job) {
    this.jobLauncher = jobLauncher;
    this.job = job;
    this.fileStorageLocation = Path.of(fileUploadDir);
  }

  public void uploadCnabFile(MultipartFile file) throws Exception {
    var filename = StringUtils.cleanPath(file.getOriginalFilename());
    var targetLocation = fileStorageLocation.resolve(filename);
      file.transferTo(targetLocation);

    var jobParameters = new JobParametersBuilder()
      .addJobParameter("cnab", file.getOriginalFilename(), String.class, true)
      .addJobParameter("cnabFile", "file:" + targetLocation.toString(), String.class, false)
      .toJobParameters();

      jobLauncher.run(job, jobParameters);
  }
}
