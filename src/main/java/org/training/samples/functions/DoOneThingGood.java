package org.training.samples.functions;

import java.util.Map;

public class DoOneThingGood {

}

class ContentRenderer {

    private static final String SCRIPT_ELEMENT = "script";

    public static void renderContent(RenderInformation renderInformation) throws InvalidElementTypeException {
        validateElementType(renderInformation.getElement());
        String content = createRenderableContent(renderInformation);
        renderOnRoot(renderInformation.getRootElement(), content);
    }

    private static void validateElementType(String element) throws InvalidElementTypeException {
        if (element.equalsIgnoreCase(SCRIPT_ELEMENT)) {
            throw new InvalidElementTypeException("Script element is not allowed.");
        }
    }

    private static String createRenderableContent(RenderInformation renderInformation) {
        String tags = createTags(renderInformation.getElement(), renderInformation.getAttributes());
        return tags + renderInformation.getContent() + "</" + renderInformation.getElement() + ">";
    }

    private static void renderOnRoot(Element rootElement, String content) {
        rootElement.innerHTML = content;
    }

    private static String createTags(String element, Map<String, String> attributes) {
        StringBuilder attributeList = new StringBuilder();
        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            attributeList.append(" ").append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\"");
        }
        String openingTag = buildTag(element, attributeList.toString(), true);
        return openingTag;
    }

    private static String buildTag(String element, String attributes, boolean isOpening) {
        StringBuilder tag = new StringBuilder();
        tag.append(isOpening ? "<" : "</");
        tag.append(element);
        tag.append(attributes);
        tag.append(isOpening ? ">" : ">");
        return tag.toString();
    }

    public static class RenderInformation {
        private final String element;
        private final String content;
        private final Element rootElement;
        private final Map<String, String> attributes;

        public RenderInformation(String element, String content, Element rootElement, Map<String, String> attributes) {
            this.element = element;
            this.content = content;
            this.rootElement = rootElement;
            this.attributes = attributes;
        }

        public String getElement() {
            return element;
        }

        public String getContent() {
            return content;
        }

        public Element getRootElement() {
            return rootElement;
        }

        public Map<String, String> getAttributes() {
            return attributes;
        }

    }

    public static class InvalidElementTypeException extends Exception {
        public InvalidElementTypeException(String message) {
            super(message);
        }
    }

    private class Element {
        public String innerHTML;
    }
}
