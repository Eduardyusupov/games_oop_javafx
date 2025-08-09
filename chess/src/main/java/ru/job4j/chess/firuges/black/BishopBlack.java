package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int stepX = (position.getX() - dest.getX() > 0) ? -1 : 1;
        int stepY = (position.getY() - dest.getY() > 0) ? -1 : 1;
        int currentX = position.getX();
        int currentY = position.getY();
        for (int index = 0; index < size; index++) {
            currentX += stepX;
            currentY += stepY;
            steps[index] = Cell.findBy(currentX, currentY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1 = Math.abs(source.getX() - dest.getX());
        int y1 = Math.abs(source.getY() - dest.getY());
        return (x1 == y1);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
