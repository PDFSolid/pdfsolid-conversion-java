import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.pdfsolid.conversion.CPDFConversion;
import com.pdfsolid.conversion.LibraryManager;
import com.pdfsolid.conversion.base.ConvertCallback;
import com.pdfsolid.conversion.base.ErrorCode;
import com.pdfsolid.conversion.base.ExcelOptions;
import com.pdfsolid.conversion.base.HtmlOptions;
import com.pdfsolid.conversion.base.ImageOptions;
import com.pdfsolid.conversion.base.JsonOptions;
import com.pdfsolid.conversion.base.MarkdownOptions;
import com.pdfsolid.conversion.base.OfdOptions;
import com.pdfsolid.conversion.base.OCRLanguage;
import com.pdfsolid.conversion.base.PptOptions;
import com.pdfsolid.conversion.base.RtfOptions;
import com.pdfsolid.conversion.base.SearchablePdfOptions;
import com.pdfsolid.conversion.base.TxtOptions;
import com.pdfsolid.conversion.base.WordOptions;

class TaskCallback implements ConvertCallback {
    @Override
    public void onProgress(int current, int total) {
        System.out.printf("Current Progress: %d / %d%n", current, total);
    }

    @Override
    public boolean isCancelled() {
        return false;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        ErrorCode errorCode = LibraryManager.licenseVerify("D:\\sdk_package\\license.xml");
        if (errorCode != ErrorCode.SUCCESS) {
            return;
        }

        if (args.length == 0) {
            throw new IllegalArgumentException("Please pass samples base path as args[0].");
        }

        String pwd = args[0];
        Path basePath = Paths.get(pwd);

        Path pdfPath = basePath.resolve("pdf");
        Path excelTestFilePath = pdfPath.resolve("excel.pdf");
        Path pptTestFilePath = pdfPath.resolve("powerpoint.pdf");
        Path wordTestFilePath = pdfPath.resolve("word.pdf");
        Path wordWithOCRTestFilePath = pdfPath.resolve("word.pdf");

        Path resourcePath = basePath.getParent().resolve("resource");
        Path modelPath = resourcePath.resolve("models").resolve("documentai.model");
        Path outputPath = basePath.resolve("output");

        LibraryManager.getVersion();
        LibraryManager.initialize(resourcePath.toString());
        LibraryManager.setDocumentAIModel(modelPath.toString());

        // pdf to word
        WordOptions wordOpt = new WordOptions();
        CPDFConversion.startPDFToWord(wordTestFilePath.toString(), "", outputPath.toString(), wordOpt, new TaskCallback());

        // pdf to excel
        ExcelOptions excelOpt = new ExcelOptions();
        CPDFConversion.startPDFToExcel(excelTestFilePath.toString(), "", outputPath.toString(), excelOpt, new TaskCallback());

        // pdf to ppt
        CPDFConversion.startPDFToPpt(pptTestFilePath.toString(), "", outputPath.toString(), new PptOptions(), new TaskCallback());

        // pdf to csv
        excelOpt.setCsvFormat(true);
        CPDFConversion.startPDFToExcel(excelTestFilePath.toString(), "", outputPath.toString(), excelOpt, new TaskCallback());

        // pdf to html
        CPDFConversion.startPDFToHtml(wordTestFilePath.toString(), "", outputPath.toString(), new HtmlOptions(), new TaskCallback());

        // pdf to rtf
        CPDFConversion.startPDFToRtf(wordTestFilePath.toString(), "", outputPath.toString(), new RtfOptions(), new TaskCallback());

        // pdf to image
        CPDFConversion.startPDFToImage(wordTestFilePath.toString(), "", outputPath.toString(), new ImageOptions(), new TaskCallback());

        // pdf to txt
        CPDFConversion.startPDFToTxt(wordTestFilePath.toString(), "", outputPath.toString(), new TxtOptions(), new TaskCallback());

        // pdf to json
        CPDFConversion.startPDFToJson(wordTestFilePath.toString(), "", outputPath.toString(), new JsonOptions(), new TaskCallback());

        // pdf to markdown
        CPDFConversion.startPDFToMarkdown(wordTestFilePath.toString(), "", outputPath.toString(), new MarkdownOptions(), new TaskCallback());

        // pdf to searchable pdf
        SearchablePdfOptions searchablePdfOpt = new SearchablePdfOptions();
        searchablePdfOpt.setEnableOcr(true);
        searchablePdfOpt.setLanguages(Arrays.asList(OCRLanguage.ENGLISH));
        CPDFConversion.startPDFToSearchablePdf(wordWithOCRTestFilePath.toString(), "", outputPath.toString(), searchablePdfOpt, new TaskCallback());

        // pdf to ofd
        OfdOptions ofdOpt = new OfdOptions();
        ofdOpt.setEnableOcr(true);
        ofdOpt.setTransparentText(true);
        ofdOpt.setLanguages(Arrays.asList(OCRLanguage.ENGLISH));
        CPDFConversion.startPDFToOfd(wordWithOCRTestFilePath.toString(), "", outputPath.resolve("output.ofd").toString(), ofdOpt, new TaskCallback());

        LibraryManager.release();
    }
}
