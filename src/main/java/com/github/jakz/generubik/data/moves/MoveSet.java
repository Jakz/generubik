package com.github.jakz.generubik.data.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveSet
{
  final private List<Move> moves;
  
  public MoveSet()
  {
    moves = new ArrayList<Move>();
  }
  
  public Stream<Move> stream() { return moves.stream(); }
  
  public MoveSet reverse()
  {
    MoveSet set = new MoveSet();
    moves.stream().map(Move::reverse).forEach(set.moves::add);
    return set;
  }
  
  public String toString()
  {
    return moves.stream()
        .map(Move::encoding)
        .collect(Collectors.joining());
  }
  
  public static MoveSet generate(int length)
  {
    java.util.Random r = new java.util.Random();
    
    MoveSet set = new MoveSet();
    
    for (int i = 0; i < length; ++i)
      set.moves.add(Move.allMoves[r.nextInt(Move.allMoves.length)]);
    
    return set;
  }
  
  @Override
  public boolean equals(Object o)
  {
    return o instanceof MoveSet && ((MoveSet)o).moves.equals(moves);
  }
}
