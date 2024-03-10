package org.training.samples.functions;

public class DoOneThing {

    public void renderContent(RenderInformation renderInformation) {
        String element = renderInformation.element;
        if (element.equalsIgnoreCase("script")) {
            throw new RuntimeException("Invalid element.");
        }

        String partialOpeningTag = "<" + element;

        // Build opening tag with attributes
        for (Attribute attribute : renderInformation.attributes) {
            partialOpeningTag += " " + attribute.name + "=\"" + attribute.value + "\"";
        }

        String openingTag = partialOpeningTag + ">";
        String closingTag = "</" + element + ">";
        String content = renderInformation.content;

        String template = openingTag + content + closingTag;

        Element rootElement = renderInformation.root;
        rootElement.setInnerHTML(template);
    }

    private class RenderInformation {
        public String element;
        public Element root;
        public String content;
        public Attribute[] attributes;
    }

    private class Element {
        public void setInnerHTML(String template) {

        }
    }

    private class Attribute {
        public String name;
        public String value;
    }
}
