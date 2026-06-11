# 1. Overview

PDFSolid Conversion SDK is a high-performance library designed for extracting and transforming the data within your PDF files, such as text, images, tables, links, and annotations, into various file formats. The Conversion SDK retains the original document layout and the properties of the file data, helping you build a reliable document conversion workflow in Java applications.

Effortlessly integrate the PDFSolid Conversion SDK into your Java projects in just a few steps, and enable the following file format conversions:

- Convert PDF to Word (.docx)
- Convert PDF to Excel (.xlsx)
- Convert PDF to PowerPoint (.pptx)
- Convert PDF to HTML (.html)
- Convert PDF to CSV (.csv)
- Convert PDF to Image (.png, .jpg, .jpeg, .jpeg2000, .bmp, .tiff, .tga, .gif, .webp)
- Convert PDF to Plain Text (.txt)
- Convert PDF to Rich Text Format (.rtf)
- Convert PDF to Searchable PDF (.pdf)
- Convert PDF to OFD (.ofd)
- Convert PDF to Structured Data (.json)
- Convert PDF to Markdown (.md)

To enhance format conversion results, PDFSolid also provides AI-powered document tools with the following capabilities:

- Optical Character Recognition (OCR)
- Layout Analysis
- Table Recognition

## 1.1 Why PDFSolid Conversion SDK

- Mature Technology

  With years of technology accumulation, PDFSolid has established a complete mechanism of product iteration to offer a continuous guarantee for product competitiveness.

- Complete PDF and Format Conversion Functionalities

  The comprehensive feature set can meet diverse conversion needs and is easy for customers to use without training costs.

- High-quality Service

  Professional service and technical support can quickly respond to users' feedback through onsite service or remote support such as telephone and email.

- Independent Intellectual Property Rights

  The technology is independent and compliant with ISO, helping enterprises conduct international business without copyright risks.

## 1.2 PDFSolid Conversion SDK for Java

The PDFSolid Conversion SDK is designed to convert PDF files into many other formats while preserving the original layout and formatting of the documents. In this guide, we will demonstrate how to use the Java API exported by the SDK in Windows, Linux, and macOS projects.

## 1.3 License & Trial

The PDFSolid Conversion SDK is a commercial SDK that requires a license to grant developers the right to develop and distribute their applications. In development mode, each license is only valid for one device ID. PDFSolid provides flexible licensing models. Please contact [our sales team](mailto:sales@pdfsolid.com) for more information. Even if you have a license, it is prohibited to distribute any documents, sample code, or source code of the PDFSolid Conversion SDK to any third parties.

If you do not have a license, please contact the PDFSolid Team at sales@pdfsolid.com to obtain a trial license for PDFSolid Conversion SDK.

# 2. Get Started

## 2.1 Requirements

Before starting, please make sure that you have met the following prerequisites.

### 2.1.1 Get PDFSolid License Key

PDFSolid provides two types of license key: 30-day free trial license and commercial license.

#### How to Get Free Trial License

Contact our sales team at sales@pdfsolid.com and we will send you a 30-day free trial license for PDFSolid Conversion SDK.

#### How to Get Commercial License

PDFSolid Conversion SDK is a commercial SDK that requires a license for application release. Any documents, sample code, or source code distribution from the released package of PDFSolid to any third party is prohibited.

To get a commercial license for PDFSolid Conversion SDK, feel free to contact our sales team at sales@pdfsolid.com.

For the Java Conversion SDK, the commercial license must be bound to your developer device ID (How to find the developer device ID), and each license is only valid for one device ID in development mode.

### 2.1.2 Download Conversion SDK

Contact us at sales@pdfsolid.com to obtain the PDFSolid Java Conversion SDK.

### 2.1.3 System Requirements

| Development Platform | System Requirements | Development Environment | Notice |
| -------------------- | ------------------- | ----------------------- | ------ |
| Windows | - Windows 7, 8, 10, and 11 (64-bit). | JDK 8 or higher. | Samples have been tested on Windows 10 and 11. |
| Linux | - Linux x64.<br />- GLIBC 2.31 or higher. | JDK 8 or higher. | Samples have been tested on Ubuntu 20.04. |
| Mac | - macOS 10.14 or higher (Intel, Apple Silicon). | JDK 8 or higher. | Samples have been tested on Mac Intel and Mac Apple Silicon. |

## 2.2 SDK Package Structure

You can contact us at sales@pdfsolid.com to get the PDF format conversion SDK package. The PDFSolid Conversion Java SDK contains the following files:

- ***"doc"*** - API reference and developer guide.
- ***"lib"*** - Contains PDFSolid Conversion Java SDK JAR.
- ***"resource"*** - DocumentAI model resources.
- ***"samples"*** - A folder containing Java sample projects.
- ***"legal.txt"*** - Legal and copyright information.
- ***"release_notes.txt"*** - Release information.

## 2.3 Apply the License Key

PDFSolid Conversion SDK currently supports offline authentication to verify license keys.

*Learn about:*

*What is the authentication mechanism of PDFSolid's license?*

### 2.3.1 Copy the License Key

Accurately obtaining the license key is crucial for applying the license.

1. In the email you received, locate the XML file containing the license key.
2. Open the XML file and determine the license type based on the `<type>` field. If `<type>online</type>` is present, it indicates an online license. If `<type>offline</type>` is present or if the field is absent, it indicates an offline license.

**Online License:**

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<license version="1">
    <platform>linux</platform>
    <starttime>xxxxxxxx</starttime>
    <endtime>xxxxxxxx</endtime>
    <type>online</type>
    <key>LICENSE_KEY</key>
</license>
```

**Offline License:**

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<license version="1">
    <platform>linux</platform>
    <starttime>xxxxxxxx</starttime>
    <endtime>xxxxxxxx</endtime>
    <key>LICENSE_KEY</key>
</license>
```

3. Copy the value located at the `LICENSE_KEY` position within the `<key>LICENSE_KEY</key>` field. This is your license key.

### 2.3.2 Apply the License Key

You can perform offline authentication using the following method:

```java
import com.pdfsolid.conversion.base.ErrorCode;
import com.pdfsolid.conversion.LibraryManager;

String license = "LICENSE_KEY";
ErrorCode errorCode = LibraryManager.licenseVerify(license);
if (errorCode != ErrorCode.SUCCESS) {
    return;
}
```

Before calling any conversion API, initialize the SDK resource directory:

```java
import com.pdfsolid.conversion.LibraryManager;

LibraryManager.initialize("PDFSolid_Conversion_SDK/resource");
```

## 2.4 How to Run a Demo

PDFSolid Conversion SDK provides demos in the ***"samples"*** folder. Before running the demo, make sure you have configured your environment correctly and installed JDK 8 or higher. To run the demo, follow these steps:

1. Open a terminal window and navigate to the ***"samples"*** folder of the PDFSolid Conversion SDK package.
2. Enter the following command to run the demo.

```shell
./run_demo.sh
```

Output files such as Word, Excel, and PowerPoint files will be generated in the ***"samples/output"*** folder.

# 3. Conversion Guides

PDFSolid Conversion SDK allows developers to use simple Java APIs to convert PDFs to common formats such as Word, Excel, PowerPoint, HTML, CSV, PNG, JPEG, RTF, TXT, Searchable PDF, OFD, JSON, and Markdown. It also provides conversion options, such as whether to include images or annotations, whether to enable OCR, and whether to enable layout analysis.

## 3.1 Initialize Library Resources

### Overview

Initialize the necessary file and memory resources required by the PDFSolid Conversion SDK.

### Notes

- You must initialize SDK resources before calling any conversion interface.
- When using OCR, Layout Analysis, Table Recognition, PDF to Searchable PDF, or PDF to OFD, make sure the DocumentAI model resources in the `resource` directory are available.

### Example

```java
LibraryManager.initialize("PDFSolid_Conversion_SDK/resource");
```

## 3.2 Set DocumentAI Model

### Overview

Before using OCR, Layout Analysis, Table Recognition, PDF to Searchable PDF, or PDF to OFD, set the DocumentAI model path first.

`setDocumentAIModel` supports the `gpuId` parameter to specify the GPU device index for the AI model. When `gpuId` is `-1`, GPU acceleration is disabled.

### Example

```java
ErrorCode code = LibraryManager.setDocumentAIModel("path/documentai.model", -1);
if (code != ErrorCode.SUCCESS) {
    return;
}
```

### Set AI Model Instance Count

If you need to control the number of Layout Analysis and Table Recognition model instances, call the following interface:

```java
LibraryManager.setDocumentAIModelCount(1, 1);
```

The first parameter indicates the number of Layout Analysis model instances, and the second parameter indicates the number of Table Recognition model instances.

### Use Your Own AI Engine (SDK v1.1.0+)

This option is available only in SDK v1.1.0 or later. If you prefer to run OCR, Layout Analysis, or Table Recognition with your own model or a third-party service instead of the bundled DocumentAI model, the SDK exposes callback hooks on `ConvertCallback` that let you supply the results as JSON. See [3.11 Use Custom AI Models via Callbacks](#311-use-custom-ai-models-via-callbacks) for details. When all capabilities you need are covered by your own callbacks, `setDocumentAIModel` does not have to be called.

## 3.3 Get Conversion Progress

PDFSolid Conversion SDK obtains conversion progress through the `ConvertCallback` interface. The following example demonstrates how to get conversion progress while performing a PDF to Word task:

```java
class ProgressClass implements ConvertCallback {
    boolean cancelled = false;

    @Override
    public void onProgress(int current, int total) {
        System.out.printf("progress: %d / %d%n", current, total);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}

WordOptions opt = new WordOptions();
CPDFConversion.startPDFToWord("input.pdf", "password", "path/output.docx", opt, new ProgressClass());
```

## 3.4 Cancel Conversion Task

PDFSolid Conversion SDK supports interrupting an ongoing conversion task through the `isCancelled()` method in `ConvertCallback`. When `isCancelled()` returns `true`, the current conversion task stops as soon as possible.

```java
class CancelClass implements ConvertCallback {
    volatile boolean cancelled = false;

    @Override
    public void onProgress(int current, int total) {
        System.out.printf("progress: %d / %d%n", current, total);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}

WordOptions opt = new WordOptions();
CancelClass callback = new CancelClass();
CPDFConversion.startPDFToWord("input.pdf", "password", "path/output.docx", opt, callback);
```

If you need to cancel the conversion at a specific time, set `cancelled = true` based on external state.

## 3.5 Select Page Range for Conversion

PDFSolid Conversion SDK supports converting a specified page range. When an empty string is passed, all pages will be converted. If the page range exceeds one page, you can enable `outputDocumentPerPage` to output each PDF page as a separate file.

```java
WordOptions opt = new WordOptions();
opt.setOutputDocumentPerPage(true);
opt.setPageRanges("1-3,5,7-9");
```

## 3.6 Contain Image and Annotation Options

### Overview

When converting PDF documents into various formats, PDFSolid Conversion SDK offers two common options: whether images are included in the generated document, and whether annotations from the PDF file are retained.

- When `containImage` is enabled, the SDK extracts images from the PDF document and embeds them in the corresponding pages and positions in the output file. For areas with overlapping images, the SDK merges these images into one image and embeds it at the correct location.
- When `containAnnotation` is enabled, most annotations are converted into raster images and embedded at the corresponding positions. Certain types of annotations, such as highlights, underlines, strikeouts, and squiggly lines, are converted into native formatting equivalents in Word, PowerPoint, and HTML documents when possible.

These options are commonly used in the following conversions:

- PDF to Word
- PDF to Excel
- PDF to PowerPoint
- PDF to HTML
- PDF to RTF
- Extract PDF to JSON
- Extract PDF to Markdown

### Sample

```java
WordOptions opt = new WordOptions();
opt.setContainImage(true);
opt.setContainAnnotation(true);

CPDFConversion.startPDFToWord("input.pdf", "password", "path/output.docx", opt);
```

## 3.7 Page Layout Mode

In certain formats, the page layout mode plays a key role in the quality of the converted document. PDFSolid Conversion SDK supports two layout modes: Flow Layout and Box Layout.

- **Flow Layout:** This layout uses paragraph indentations, columns, and tab positions to adjust content. Its main advantage is flexibility. Content can flow automatically as the document is edited and can adapt to different screen sizes.
- **Box Layout:** This layout is based on the PDF fixed-page model and accurately positions text, images, and tables on the page using coordinates. It is useful for documents that require high-precision reproduction, such as contracts, design drafts, and academic papers.

Page layout modes are commonly used in the following conversions:

- PDF to Word
- PDF to HTML

### Sample

```java
WordOptions opt = new WordOptions();

opt.setLayoutMode(PageLayoutMode.FLOW);
CPDFConversion.startPDFToWord("input.pdf", "password", "path/flow.docx", opt);

opt.setLayoutMode(PageLayoutMode.BOX);
CPDFConversion.startPDFToWord("input.pdf", "password", "path/box.docx", opt);
```

## 3.8 OCR

### Overview

OCR (Optical Character Recognition) converts images of typed, handwritten, or printed text into machine-encoded text.

OCR is commonly used for text recognition and extraction from the following types of documents:

- Non-editable scanned PDF files.
- Photographs of documents.
- Scene photos such as advertising layouts and signboards.
- Identification cards, passports, vehicle license plates, invoices, bills, and receipts.

The following features support OCR:

- PDF to Word
- PDF to Excel
- PDF to PowerPoint
- PDF to HTML
- PDF to RTF
- PDF to TXT
- PDF to CSV
- PDF to Searchable PDF
- PDF to OFD
- Extract PDF to JSON
- Extract PDF to Markdown

### OCR Language

Pass OCR languages through `options.setOcrLanguages()` for each conversion task.

```java
LibraryManager.setDocumentAIModel("path/model");

WordOptions opt = new WordOptions();
opt.setEnableOcr(true);
opt.setOcrLanguages(Arrays.asList(OCRLanguage.ENGLISH));

CPDFConversion.startPDFToWord("word.pdf", "password", "path/output.docx", opt);
```

Supported OCR languages include:

| Script / Notes | Language (Native) | Language (In English) |
| -------------- | ----------------- | --------------------- |
| Latn; American | English | English |
| Latn; Canadian | Français canadien | French |
| Hans/Hant | 中文简体 | Chinese (Simplified) |
| Hans/Hant | 中文繁体 | Chinese (Traditional) |
| Jpan | 日本語 | Japanese |
| Kore | 한국어 | Korean |
| Latn | Deutsch | German |
| Latn | Српски (латиница) | Serbian (latin) |
| Latn | Occitan, lenga d'òc, provençal | Occitan |
| Latn | Dansk | Danish |
| Latn | Italiano | Italian |
| Latn; European | Español | Spanish |
| Latn; European | Português (Portugal) | Portuguese |
| Latn | Te reo Māori | Maori |
| Latn | Bahasa Melayu | Malay |
| Latn | Malti | Maltese |
| Latn | Nederlands | Dutch |
| Latn; Bokmål | Norsk | Norwegian |
| Latn | Polski | Polish |
| Latn | Română | Romanian |
| Latn | Slovenčina | Slovak |
| Latn | Slovenščina | Slovenian |
| Latn | shqip | Albanian |
| Latn | Svenska | Swedish |
| Latn | Swahili | Swahili |
| Latn | Wikang Tagalog | Tagalog |
| Latn | Türkçe | Turkish |
| Latn | oʻzbekcha | Uzbek |
| Latn | Tiếng Việt | Vietnamese |
| Latn | Afrikaans | Afrikaans |
| Latn | Azərbaycan | Azerbaijani |
| Latn | Bosanski | Bosnian |
| Latn | Čeština | Czech |
| Latn | Cymraeg | Welsh |
| Latn | Eesti keel | Estonian |
| Latn | Gaeilge | Irish |
| Latn | Hrvatski | Croatian |
| Latn | Magyar | Hungarian |
| Latn | Bahasa Indonesia | Indonesian |
| Latn | Íslenska | Icelandic |
| Latn | Kurdî | Kurdish |
| Latn | Lietuvių | Lithuanian |
| Latn | Latviešu | Latvian |

### OCR Options

Different OCR options can be selected according to actual needs:

- **INVALID_CHARACTER:** Recognizes invalid or garbled characters in the PDF document through OCR, while normal characters are not processed by OCR.
- **SCAN_PAGE:** Recognizes scanned pages in the PDF document through OCR, while editable pages are not processed by OCR.
- **INVALID_CHARACTER_AND_SCAN_PAGE:** Recognizes both invalid characters and scanned pages in the PDF document through OCR.
- **ALL:** Recognizes all pages and characters in the PDF document through OCR.

### Preserve Page Background

When OCR is enabled, you can enable `containPageBackgroundImage` to preserve the original page background image of the PDF. If it is disabled, the image result detected during page layout analysis will be retained.

### Notice

- The quality of the OCR result depends on the quality of the input image. A good rule of thumb is that the more pixels in the character shapes, the better. The ideal image is a grayscale image with a resolution around 300 DPI.
- When performing OCR, make sure the OCR language setting matches the language in the PDF document to achieve the best OCR conversion quality.
- OCR functionality currently does not support operating systems lower than Windows 10.

### Converting Images to Other Document Formats

The OCR function also supports converting input images into Word, Excel, PowerPoint, HTML, CSV, RTF, TXT, JSON, and other formats.

```java
LibraryManager.setDocumentAIModel("path/model");

WordOptions opt = new WordOptions();
opt.setEnableOcr(true);
opt.setOcrLanguages(Arrays.asList(OCRLanguage.ENGLISH));

// Supports jpg, jpeg, png, bmp, tiff formats.
CPDFConversion.startPDFToWord("input.png", "", "path/output.docx", opt);
```

## 3.9 Layout Analysis

### Overview

Layout analysis uses AI technology to parse and understand the structure of a document layout. It extracts text, images, tables, layers, and other data from input documents.

Features that support Layout Analysis:

- PDF to Word
- PDF to Excel
- PDF to PowerPoint
- PDF to HTML
- PDF to RTF
- PDF to TXT
- PDF to CSV
- Extract PDF to JSON
- Extract PDF to Markdown

### Notice

- You need to load the DocumentAI model before using layout analysis, or plug in your own AI engine via callbacks described in [3.11 Use Custom AI Models via Callbacks](#311-use-custom-ai-models-via-callbacks).
- When OCR is enabled, layout analysis is automatically enabled.
- AI table recognition is a separate stage controlled by `enableAiTableRecognition`.

### Sample

```java
LibraryManager.setDocumentAIModel("path/model");

WordOptions opt = new WordOptions();
opt.setEnableAiLayout(true);

CPDFConversion.startPDFToWord("word.pdf", "password", "path/output.docx", opt);
```

## 3.10 Table Recognition

### Overview

Table Recognition reconstructs the internal structure of tables detected during layout analysis, including rows, columns, merged cells, and cell boundaries, so that the converted document preserves the original tabular semantics instead of producing a flat grid of text fragments.

It is controlled by the independent option `enableAiTableRecognition`, which is enabled by default. The table model is invoked for table regions detected by layout analysis.

Typical scenarios that benefit from Table Recognition:

- Borderless or partially bordered tables.
- Tables with merged header cells, multi-row headers, or spanning cells.
- Scanned tables processed by OCR.

### Notice

- Table Recognition runs only when layout analysis is active, either through `enableAiLayout = true` or implicitly through `enableOcr = true`.
- You need to load the DocumentAI model before using Table Recognition, or plug in your own table model via callbacks described in [3.11 Use Custom AI Models via Callbacks](#311-use-custom-ai-models-via-callbacks).
- Set `enableAiTableRecognition = false` to disable the table model.
- The number of Table Recognition model instances can be tuned through the second parameter of `setDocumentAIModelCount`.

### Sample

```java
LibraryManager.setDocumentAIModel("path/model");

WordOptions opt = new WordOptions();
opt.setEnableAiLayout(true);
opt.setEnableAiTableRecognition(true);

CPDFConversion.startPDFToWord("word.pdf", "password", "path/output.docx", opt);
```

## 3.11 Use Custom AI Models via Callbacks

### Overview

Starting with SDK v1.1.0, PDFSolid Conversion SDK exposes a callback-based extension point that lets you plug in your own AI inference engine for OCR, Layout Analysis, and Table Recognition. Instead of relying on the built-in DocumentAI model loaded by `setDocumentAIModel`, you can run inference with any model or service and return the result to the SDK as a JSON string.

When the relevant callback pair is registered on `ConvertCallback`, the SDK skips its built-in model invocation for that capability and consumes your JSON output instead. If a pair is left unset, the SDK falls back to the built-in DocumentAI model when available.

### Callback Pairs

Each AI capability uses two callbacks: a trigger callback invoked by the SDK with the path to a page image saved as PNG in a temporary directory, and a result getter invoked by the SDK immediately afterwards to retrieve the JSON string.

| Capability | Trigger callback | Result getter callback | Triggered when |
| ---------- | ---------------- | ---------------------- | -------------- |
| OCR | `onOcr` | `getOcrResult` | `enableOcr = true` |
| Layout Analysis | `onLayout` | `getLayoutResult` | `enableAiLayout = true` or `enableOcr = true` |
| Table Recognition | `onTable` | `getTableResult` | `enableAiTableRecognition = true` and a table region is detected by layout analysis |

Rules:

- The trigger receives a UTF-8 path to a PNG file. Return `true` if inference succeeded, or `false` to make the SDK ignore the result for that page.
- The getter must return a UTF-8 JSON string. The SDK copies the string into an internal buffer before consuming it.
- Both callbacks for a capability must be set together. If only one is provided, the SDK falls back to the built-in path.
- Coordinates in your JSON must be in the pixel space of the image received by the trigger, with top-left origin, X to the right, and Y down.

### Sample

```java
class CustomAICallback implements ConvertCallback {
    @Override
    public void onProgress(int currentPage, int totalPage) {}

    @Override
    public boolean isCancelled() { return false; }

    @Override
    public boolean onOcr(String imagePath) {
        // Run your OCR engine on imagePath, cache the JSON result.
        return true;
    }

    @Override
    public boolean onLayout(String imagePath) {
        // Run your layout engine on imagePath.
        return true;
    }

    @Override
    public boolean onTable(String imagePath) {
        // Run your table engine on imagePath.
        return true;
    }

    @Override
    public String getOcrResult()    { return ""; }  // return UTF-8 JSON
    @Override
    public String getLayoutResult() { return ""; }
    @Override
    public String getTableResult()  { return ""; }
}

WordOptions opt = new WordOptions();
opt.setEnableOcr(true);
opt.setEnableAiLayout(true);
opt.setEnableAiTableRecognition(true);
CPDFConversion.startPDFToWord("input.pdf", "", "output.docx", opt, new CustomAICallback());
```

You can register only the capabilities you want to override and leave others unset to keep the built-in behavior.

### Thread Safety and Lifetime

- Callbacks are invoked from the SDK conversion thread. Implement them in a thread-safe manner if your model engine is shared across calls.
- The PNG image at `imagePath` lives in the SDK temporary directory and may be deleted shortly after the trigger returns. Copy or process it before returning.
- The JSON string returned from a getter must remain valid until the same getter is called again or until the conversion task ends.

### OCR Result JSON Schema

Returned by `getOcrResult`. The SDK populates each `textSpans[].chars[]` either from `words[]` if provided, or by uniformly splitting the span rect.

```json
{
  "text_spans": [
    {
      "text": "Hello World",
      "confidence": 0.98,
      "rotation": 0.0,
      "rect": { "left": 120, "top": 80, "right": 320, "bottom": 110 },
      "style": {
        "font_size": 18.0,
        "font_color": { "r": 0, "g": 0, "b": 0 }
      },
      "words": [
        { "text": "Hello", "rect": { "left": 120, "top": 80, "right": 200, "bottom": 110 } },
        { "text": "World", "rect": { "left": 210, "top": 80, "right": 320, "bottom": 110 } }
      ]
    }
  ]
}
```

| Field | Type | Required | Description |
| ----- | ---- | -------- | ----------- |
| `text_spans` | array | Yes | Recognized text spans on the page. |
| `text` | string | Yes | UTF-8 text content of the span. |
| `confidence` | number | No | 0.0 – 1.0. Spans below 0.1 are discarded. |
| `rotation` | number | No | Text rotation in degrees. Default 0. |
| `rect` | object | Yes | Bounding box in image pixels (`left`/`top`/`right`/`bottom`). |
| `style.font_size` | number | No | Estimated font size in pixels. |
| `style.font_color` | object | No | `{ r, g, b }` 0 – 255. |
| `words` | array | No | Per-word boxes. If omitted, the SDK splits the span rect evenly. Strongly recommended for CJK + Latin mixed lines for correct glyph spacing. |

### Layout Analysis Result JSON Schema

Returned by `getLayoutResult`. Objects with `confidence < 0.45` are discarded.

```json
{
  "objects": [
    { "type": "title", "confidence": 0.95, "rect": { "left": 60, "top": 50, "right": 540, "bottom": 90 } },
    { "type": "paragraph", "confidence": 0.97, "rect": { "left": 60, "top": 100, "right": 540, "bottom": 220 } },
    { "type": "figure", "confidence": 0.92, "rect": { "left": 80, "top": 240, "right": 520, "bottom": 460 } },
    { "type": "table", "confidence": 0.93, "rect": { "left": 60, "top": 480, "right": 540, "bottom": 700 } }
  ]
}
```

Supported `type` values:

| Value | Meaning |
| ----- | ------- |
| `paragraph` | Body text paragraph |
| `title` | Heading |
| `figure` | Image or figure |
| `figure_title` | Figure caption header |
| `figure_caption` | Figure caption text |
| `table` | Table region. Whether the table is bordered or borderless is determined by the table recognition stage, not by the layout label. |
| `table_title` | Table caption header |
| `table_caption` | Table caption text |
| `ordered_list` | Ordered list |
| `unordered_list` | Unordered list |
| `catalogue` | Table of contents |
| `formula` | Math formula |
| `code` | Code block |
| `algorithm` | Algorithm block |
| `header` | Page header |
| `footer` | Page footer |
| `page_number` | Page number |
| `reference` | Reference or citation |

Objects with a `type` value that is not listed above are ignored. Use the values in this table as the canonical layout labels in your custom output.

### Table Recognition Result JSON Schema

Returned by `getTableResult` once per detected table region. Polygons use eight integers `[x0, y0, x1, y1, x2, y2, x3, y3]` in the order top-left, top-right, bottom-right, bottom-left.

```json
{
  "type": "table_with_line",
  "position": [60, 480, 540, 480, 540, 700, 60, 700],
  "rows": 3,
  "cols": 2,
  "angle": 0.0,
  "height_of_rows": [40, 60, 60],
  "width_of_cols": [200, 280],
  "table_cells": [
    {
      "start_row": 0,
      "end_row": 0,
      "start_col": 0,
      "end_col": 0,
      "cell_background_color_r": 240,
      "cell_background_color_g": 240,
      "cell_background_color_b": 240,
      "position": [60, 480, 260, 480, 260, 520, 60, 520]
    }
  ]
}
```

| Field | Type | Description |
| ----- | ---- | ----------- |
| `type` | string | `table_with_line` for bordered tables; any other value is treated as a non-standard (borderless) table. |
| `position` | int[8] | Table polygon in image pixels. |
| `rows` / `cols` | int | Row / column counts. |
| `angle` | number | Skew angle in degrees. |
| `height_of_rows` | int[] | Per-row pixel heights (length = `rows`). |
| `width_of_cols` | int[] | Per-column pixel widths (length = `cols`). |
| `table_cells[]` | array | One entry per merged cell. |
| `start_row` / `end_row` | int | Inclusive row span of the cell. |
| `start_col` / `end_col` | int | Inclusive column span of the cell. |
| `cell_background_color_*` | int | Cell background color components (0 – 255). |
| `position` | int[8] | Cell polygon in image pixels. |

### Tip: Validate Your JSON

If you need a reference output to compare against, run a conversion once with the built-in DocumentAI model. The SDK uses the same JSON shape internally, so your custom output should follow the same structure.

## 3.12 Output Font Option

### Overview

In some output formats, you can set the preferred font name to unify the default font style in the output document.

### Supported Formats

The `fontName` option currently applies to the following formats:

- PDF to Word
- PDF to Excel
- PDF to PowerPoint
- PDF to Searchable PDF
- PDF to OFD

For Searchable PDF and OFD, `fontName` controls the font used for the invisible or visible text layer that is overlaid on the page background. For Word, Excel, and PowerPoint, it sets the preferred default font of the generated document.

### Example

```java
WordOptions opt = new WordOptions();
opt.setFontName("Arial");

CPDFConversion.startPDFToWord("word.pdf", "password", "path/output.docx", opt);
```

## 3.13 Convert PDF to Word

### Overview

Converting PDF to Word converts a PDF file into an editable Word file. You can edit, modify, insert, or delete text and pictures, and adjust layout and properties.

### Sample

```java
WordOptions opt = new WordOptions();

opt.setLayoutMode(PageLayoutMode.BOX);
CPDFConversion.startPDFToWord("word.pdf", "password", "path/output_box.docx", opt);

opt.setLayoutMode(PageLayoutMode.FLOW);
CPDFConversion.startPDFToWord("word.pdf", "password", "path/output_flow.docx", opt);
```

### Convert Formulas to Images

When a document contains complex formulas and you want to preserve visual consistency in the output document, enable `formulaToImage`.

```java
WordOptions opt = new WordOptions();
opt.setFormulaToImage(true);

CPDFConversion.startPDFToWord("word.pdf", "password", "path/output.docx", opt);
```

## 3.14 Convert PDF to Excel

### Overview

PDFSolid Conversion SDK supports converting PDF documents to Microsoft Excel format (.xlsx). By extracting, parsing, and importing data from PDF into Excel, users can further edit, analyze, or share Excel files.

### Excel Options

When converting PDF files to Excel files, pay attention to the following options:

- `allContent`: If enabled, the converted XLSX file contains all content in the PDF.
- `worksheetOption`: Controls how worksheets are created.

| Option | Description |
| ------ | ----------- |
| `ExcelWorksheetOption.FOR_TABLE` | Create one sheet for one table. |
| `ExcelWorksheetOption.FOR_PAGE` | Create one sheet for one PDF page. |
| `ExcelWorksheetOption.FOR_DOCUMENT` | Create one sheet for the entire PDF document. |

### Sample

```java
ExcelOptions opt = new ExcelOptions();
CPDFConversion.startPDFToExcel("excel.pdf", "password", "path/output.xlsx", opt);

opt.setAllContent(true);
opt.setWorksheetOption(ExcelWorksheetOption.FOR_DOCUMENT);
CPDFConversion.startPDFToExcel("excel.pdf", "password", "path/output_all.xlsx", opt);
```

## 3.15 Convert PDF to PowerPoint

### Overview

PDFSolid Conversion SDK converts PDF files to PowerPoint files and restores the layout and format of the original document for presentation and editing in Microsoft PowerPoint.

### Sample

```java
PptOptions opt = new PptOptions();
CPDFConversion.startPDFToPpt("ppt.pdf", "password", "path/output.pptx", opt);
```

## 3.16 Convert PDF to HTML

### Overview

PDFSolid Conversion SDK converts PDF files to HTML files while maintaining the layout and format of the original document, allowing users to browse and view the document on the web.

### HTML Options

| Option | Description |
| ------ | ----------- |
| `HtmlPageOption.SINGLE_PAGE` | Convert the entire PDF file into a single HTML file. |
| `HtmlPageOption.SINGLE_PAGE_WITH_BOOKMARK` | Convert the PDF file into a single HTML file with an outline for navigation at the beginning of the HTML page. |
| `HtmlPageOption.MULTIPLE_PAGE` | Convert the PDF file into multiple HTML files. |
| `HtmlPageOption.MULTIPLE_PAGE_WITH_BOOKMARK` | Convert the PDF file into multiple HTML files with an outline HTML file for navigation. |

### Sample

```java
HtmlOptions opt = new HtmlOptions();
CPDFConversion.startPDFToHtml("html.pdf", "password", "path/output.html", opt);

opt.setLayoutMode(PageLayoutMode.BOX);
opt.setHtmlPageOption(HtmlPageOption.MULTIPLE_PAGE_WITH_BOOKMARK);
CPDFConversion.startPDFToHtml("html.pdf", "password", "path/output_multi.html", opt);
```

## 3.17 Convert PDF to CSV

### Overview

PDFSolid Conversion SDK supports converting PDF documents to CSV (Comma-Separated Values). This is commonly used to extract tabular or structured data from PDF documents.

CSV conversion uses the Excel conversion API with `csvFormat = true`.

### Automatically Create Folders

When multiple CSV files may be output, control whether to automatically create folders through `autoCreateFolder`. When this option is enabled, a folder with the same name as the output file will be created in the output path to store the CSV files.

### Sample

```java
ExcelOptions opt = new ExcelOptions();
opt.setCsvFormat(true);

CPDFConversion.startPDFToExcel("csv.pdf", "password", "path/output.csv", opt);

opt.setWorksheetOption(ExcelWorksheetOption.FOR_DOCUMENT);
CPDFConversion.startPDFToExcel("csv.pdf", "password", "path/output_merged.csv", opt);
```

## 3.18 Convert PDF to Image

### Overview

PDFSolid Conversion SDK provides an API for converting PDF to images.

### Setting Image Formats

Supported image formats include:

- JPG
- JPEG
- JPEG2000
- PNG
- BMP
- TIFF
- TGA
- GIF
- WEBP

### Setting Image Color Modes

Supported image color modes include:

- **Color:** Color mode, where the image effect is consistent with the original PDF page.
- **Gray:** Grayscale mode.
- **Binary:** Black and white mode.

### Setting Image Scaling

The SDK supports setting image scaling. If you want to double the image size, set `imageScaling` to `2.0`; to reduce the image size by half, set `imageScaling` to `0.5`.

### Enhancing Image Path Display

The SDK supports `pathEnhance` for enhancing the display of image paths. This option can be enabled when you want to improve the display effect of paths within the PDF page.

- Disable `pathEnhance` option:
  ![Disable pathEnhance](image/1.png)
- Enable `pathEnhance` option:
  ![Enable pathEnhance](image/2.png)

### Notice

- A higher `imageScaling` value results in images with higher resolution, but it also increases memory usage and slows down conversion.
- A higher `imageScaling` value does not necessarily mean higher clarity. The clarity also depends on the original image resolution in the document.

### Sample

```java
ImageOptions opt = new ImageOptions();

opt.setImageType(ImageType.JPEG);
CPDFConversion.startPDFToImage("jpeg.pdf", "password", "path/output", opt);

opt.setImageType(ImageType.PNG);
opt.setImageScaling(2.0);
CPDFConversion.startPDFToImage("png.pdf", "password", "path/output", opt);
```

## 3.19 Convert PDF to RTF

### Overview

RTF is a popular text format that can retain text format and style data and is convenient for most text readers to read and write.

### Sample

```java
RtfOptions opt = new RtfOptions();
CPDFConversion.startPDFToRtf("rtf.pdf", "password", "path/output.rtf", opt);
```

## 3.20 Convert PDF to TXT

### Overview

When you need to extract text content from a PDF file for data analysis, text mining, or information retrieval, PDFSolid Conversion SDK can extract the text into a TXT file.

### Preserving Table Format

The SDK supports `tableFormat` to preserve the table format when writing the TXT file. It is generally recommended to enable this option, especially for data extraction scenarios.

### Sample

```java
TxtOptions opt = new TxtOptions();
opt.setTableFormat(true);

CPDFConversion.startPDFToTxt("txt.pdf", "password", "path/output.txt", opt);
```

## 3.21 Convert PDF to Searchable PDF

### Overview

Searchable PDF conversion adds an invisible or visible text layer to an image-based PDF, such as a scanned document, using OCR.

### Set Transparent Text Layer

When outputting a searchable PDF, use `transparentText` to control whether the text layer is transparent.

### Sample

```java
LibraryManager.setDocumentAIModel("path/model");

SearchablePdfOptions opt = new SearchablePdfOptions();
opt.setEnableOcr(true);
opt.setOcrLanguages(Arrays.asList(OCRLanguage.ENGLISH));
opt.setTransparentText(true);

CPDFConversion.startPDFToSearchablePdf("scan.pdf", "password", "path/output.pdf", opt);
```

## 3.22 Convert PDF to OFD

### Overview

PDFSolid Conversion SDK supports converting PDF documents to OFD documents. Similar to Searchable PDF, OFD conversion also supports OCR, page background preservation, and transparent text layers.

### Notice

- If you need to generate searchable OFD output, enable `transparentText`.
- When `enableOcr` is enabled, specify the OCR language through `setOcrLanguages`.

### Sample

```java
LibraryManager.setDocumentAIModel("path/model");

OfdOptions opt = new OfdOptions();
opt.setEnableOcr(true);
opt.setOcrLanguages(Arrays.asList(OCRLanguage.ENGLISH));
opt.setContainPageBackgroundImage(true);
opt.setTransparentText(true);

CPDFConversion.startPDFToOfd("scan.pdf", "password", "path/output.ofd", opt);
```

## 3.23 Releasing Library Resources

### Overview

Release the file and memory resources occupied by the PDFSolid Conversion SDK.

### Notice

- After calling `release`, the PDFSolid Conversion SDK will no longer function properly and must be initialized again before reuse.
- If you only want to release resources occupied by the AI model rather than all SDK resources, call `releaseDocumentAIModel`.

### Sample

```java
LibraryManager.releaseDocumentAIModel();
LibraryManager.release();
```

# 4. Data Extraction Guide

Unleash the power of data with PDFSolid Conversion SDK data extraction to detect, recognize, analyze, and extract PDF text, images, tables, and other content.

## 4.1 Extract PDF to JSON

### Overview

Extract text, tables, and images from PDF documents to a JSON file.

### Standard Table and Non-standard Table

Tables can commonly be divided into two categories:

- Standard table: The table border and inner lines are complete and clear. There is no need to manually add table lines to divide table content.
  ![Standard table example](image/3.png)
- Non-standard table: The table lacks borders or clear inner lines, requiring manual additions of table lines to separate content.
  ![Non-standard table example](image/4.png)

### Table Extraction Option

PDFSolid Conversion SDK supports `containTable`. When enabled, the SDK extracts table content from PDFs and outputs the table structure. Otherwise, table content is treated as regular text.

### Notice

- Without enabling AI layout analysis or OCR options, tables in the original PDF may not be extracted. It is recommended to enable AI layout analysis or OCR for high-precision table recognition.

### Sample

```java
JsonOptions opt = new JsonOptions();
opt.setContainTable(true);

CPDFConversion.startPDFToJson("json.pdf", "password", "path/output.json", opt);
```

## 4.2 Extract PDF to Markdown

### Overview

Extract text, tables, and images from PDF documents to a Markdown file.

### Sample

```java
MarkdownOptions opt = new MarkdownOptions();

CPDFConversion.startPDFToMarkdown("markdown.pdf", "password", "path/output.md", opt);
```

# 5. Support

## 5.1 FAQ

- Does OCR work on x86 architecture?

  Currently, OCR only works on x64 architecture.

## 5.2 Contact Us

Thanks for your interest in PDFSolid Conversion SDK, the easy-to-use and powerful development solution. If you encounter technical questions or bug issues when using PDFSolid Conversion SDK, please submit the problem report to the [PDFSolid team](mailto:support@pdfsolid.com). The following information will help us solve your problem:

- PDFSolid Conversion SDK product and version.
- Your operating system and IDE version.
- Detailed descriptions of the problem.
- Any other related information, such as an error screenshot.

### Contact Information

- Home link: [https://www.pdfsolid.com](https://www.pdfsolid.com/)
- Email: [support@pdfsolid.com](mailto:support@pdfsolid.com)

Thanks,

The PDFSolid Team
