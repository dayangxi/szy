package com.yangxi.szy;

import com.yangxi.szy.relationtree.FamilyTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyTests {
    private static final Logger log = LoggerFactory.getLogger(FamilyTests.class);

    @Autowired
    private FamilyTree familyTree;

    @Test
    public void addNode() {
        familyTree.addPlayer("0x11", "0x00");
        familyTree.addPlayer("0x111", "0x11");
        familyTree.addPlayer("0x112", "0x11");

        familyTree.addPlayer("0x22", "0x00");
        familyTree.addPlayer("0x211", "0x22");
        familyTree.addPlayer("0x212", "0x22");

        familyTree.prtAllSons();
    }
}
