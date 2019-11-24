package com.github.jakz.generubik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.github.jakz.generubik.data.Color;
import com.github.jakz.generubik.data.Cube;
import com.github.jakz.generubik.data.Face;
import com.github.jakz.generubik.data.Facet;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  CubeTests.class,
  FaceTests.class,
  CubeRotationMoveTests.class
})
public class Tests
{

}
