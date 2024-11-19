package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestChainLink {

  ChainLink link;

  @BeforeEach
  void setUp() {
    link = new ChainLink("default");
  }

  @Test
  void testToString(){
    ChainLink someLink = new ChainLink("purple");
    assertEquals("ChainLink{color='purple'}", someLink.toString());
  }

  @Test
  void TestNodeLinking(){
    ChainLink linkOne = new ChainLink("red");
    Node nodeOne = new Node(linkOne);

    ChainLink linkTwo = new ChainLink("blue");
    Node nodeTwo = new Node(linkTwo);

    ChainLink linkThree = new ChainLink("green");
    Node nodeThree = new Node(linkThree);

    nodeOne.setNext(nodeTwo);
    nodeTwo.setNext(nodeThree);

    Node setNode = nodeOne.getNext();
    ChainLink setLink = setNode.getData();
    assertEquals("blue", setLink.color);

    Node setNodeTwo = nodeOne.getNext().getNext();
    ChainLink setLinkTwo = setNodeTwo.getData();
    assertEquals("green", setLinkTwo.color);
  }

  @Test
  void testNullInNode(){
    ChainLink nullLink = new ChainLink(null);
    Node nullNode = new Node(nullLink);

    assertEquals("ChainLink{color='null'}", nullLink.toString());
    assertEquals(null, nullNode.getData().color);
  }
}
