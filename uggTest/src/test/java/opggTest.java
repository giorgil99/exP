import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Test
public class opggTest {

    public void opgg() throws IOException {

        Configuration.browser = "Edge";
        Configuration.holdBrowserOpen = true;
        open("https://eune.op.gg/summoner/userName=lem0nrex");
        $("#top_tiergraph").click();
       $("#left_champion_more > a").scrollTo();
        $("#left_champion_flexrank5v5").scrollIntoView(true);
        System.out.println($("div.TierRank").getText());
        $("div.SummonerRatingMedium").scrollTo();

    // takes screenshot in selenide
         File source =  takeScreenShotAsFile();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
        String a = dtf.format(LocalDateTime.now());
        Path root = Paths.get(".").normalize().toAbsolutePath();
        String screenName = root + "\\" + "TestShot2_" + a + ".png";
        FileUtils.copyFile(source, new File(screenName));
//
        $("#top_tiergraph").scrollTo();


        String screenName1 = root + "\\" + "TestShot1_" + a + ".png";
        File source1 =  takeScreenShotAsFile();
        FileUtils.copyFile(source1, new File(screenName1));
    }


}
