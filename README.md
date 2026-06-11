# PDFSolid Conversion SDK for Java

High-performance Java SDK for converting PDF to Word, Excel, PowerPoint, HTML, Image, TXT, RTF, CSV, JSON, Markdown, Searchable PDF, and OFD with AI-powered OCR, layout analysis, and table recognition.

## Features

- **PDF to Word** (.docx) — Flow and Box layout modes
- **PDF to Excel** (.xlsx) — per-table, per-page, or per-document worksheet options
- **PDF to PowerPoint** (.pptx)
- **PDF to HTML** (.html) — single/multi-page with optional bookmark navigation
- **PDF to CSV** (.csv)
- **PDF to Image** (.png, .jpg, .jpeg, .jpeg2000, .bmp, .tiff, .tga, .gif, .webp) — color/grayscale/binary, configurable scaling
- **PDF to Plain Text** (.txt) — optional table format preservation
- **PDF to RTF** (.rtf)
- **PDF to Searchable PDF** (.pdf) — OCR with transparent text layer
- **PDF to OFD** (.ofd) — OCR, page background preservation, transparent text layer
- **PDF to JSON** (.json) — structured data with table extraction
- **PDF to Markdown** (.md)

### AI-Powered Document Tools

- **OCR** — Optical Character Recognition for scanned documents and images
- **Layout Analysis** — AI-based document structure parsing
- **Table Recognition** — AI-based table structure reconstruction
- **Custom AI Models** — plug in your own OCR, layout, or table engine via callbacks (SDK v1.1.0+)

## Requirements

| Platform | System Requirements | Development Environment |
| -------- | ------------------- | ----------------------- |
| Windows | Windows 7, 8, 10, 11 (64-bit) | JDK 8+ |
| Linux | Linux x64, GLIBC 2.31+ | JDK 8+ |
| macOS | macOS 10.14+ (Intel, Apple Silicon) | JDK 8+ |

## Quick Start

### 1. Get a License

Contact [sales@pdfsolid.com](mailto:sales@pdfsolid.com) for a 30-day free trial or commercial license.

### 2. Apply License and Initialize

```java
import com.pdfsolid.conversion.base.ErrorCode;
import com.pdfsolid.conversion.LibraryManager;

ErrorCode code = LibraryManager.licenseVerify("LICENSE_KEY");
if (code != ErrorCode.SUCCESS) {
    return;
}
LibraryManager.initialize("PDFSolid_Conversion_SDK/resource");
```

### 3. Convert

```java
import com.pdfsolid.conversion.CPDFConversion;
import com.pdfsolid.conversion.WordOptions;

WordOptions opt = new WordOptions();
CPDFConversion.startPDFToWord("input.pdf", "", "output.docx", opt);
```

### Release Resources

```java
LibraryManager.releaseDocumentAIModel();
LibraryManager.release();
```

## Conversion Examples

### PDF to Excel

```java
ExcelOptions opt = new ExcelOptions();
opt.setWorksheetOption(ExcelWorksheetOption.FOR_TABLE);
CPDFConversion.startPDFToExcel("input.pdf", "", "output.xlsx", opt);
```

### PDF to Image

```java
ImageOptions opt = new ImageOptions();
opt.setImageType(ImageType.PNG);
opt.setImageScaling(2.0);
CPDFConversion.startPDFToImage("input.pdf", "", "output", opt);
```

### PDF to Searchable PDF (OCR)

```java
LibraryManager.setDocumentAIModel("path/model");

SearchablePdfOptions opt = new SearchablePdfOptions();
opt.setEnableOcr(true);
opt.setOcrLanguages(Arrays.asList(OCRLanguage.ENGLISH));
opt.setTransparentText(true);
CPDFConversion.startPDFToSearchablePdf("scan.pdf", "", "output.pdf", opt);
```

### PDF to JSON with Table Extraction

```java
JsonOptions opt = new JsonOptions();
opt.setContainTable(true);
CPDFConversion.startPDFToJson("input.pdf", "", "output.json", opt);
```

### Custom AI Engine (SDK v1.1.0+)

```java
class CustomAICallback implements ConvertCallback {
    @Override public void onProgress(int current, int total) {}
    @Override public boolean isCancelled() { return false; }
    @Override public boolean onOcr(String imagePath) { /* your OCR */ return true; }
    @Override public boolean onLayout(String imagePath) { /* your layout */ return true; }
    @Override public boolean onTable(String imagePath) { /* your table */ return true; }
    @Override public String getOcrResult() { return ""; }
    @Override public String getLayoutResult() { return ""; }
    @Override public String getTableResult() { return ""; }
}

WordOptions opt = new WordOptions();
opt.setEnableOcr(true);
opt.setEnableAiLayout(true);
CPDFConversion.startPDFToWord("input.pdf", "", "output.docx", opt, new CustomAICallback());
```

## Documentation

- [Developer Guide](doc/developer_guide_java.md)
- [API Reference](doc/api_reference/)

## Contact

- Website: [https://www.pdfsolid.com](https://www.pdfsolid.com/)
- Sales: [sales@pdfsolid.com](mailto:sales@pdfsolid.com)
- Support: [support@pdfsolid.com](mailto:support@pdfsolid.com)
