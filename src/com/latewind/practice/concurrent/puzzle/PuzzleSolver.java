package com.latewind.practice.concurrent.puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lsqwell
 * 递归方法走迷宫
 * 缺点：只能走一条通道的迷宫，多条通道的会按照另一条路原路 循环 StackFlow
 */


public class PuzzleSolver {
    private int[][] map = {
            {1, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
    };
    private Point startPoint = new Point(0, 1, null);
    private Point endPoint = new Point(0, 4, null);
    private Point aimPoint = null;
    private ConcurrentHashMap<Point, Boolean> seen = new ConcurrentHashMap<PuzzleSolver.Point, Boolean>();
    private ExecutorService exec = Executors.newFixedThreadPool(5);

    public void sequentialShow() {
        new Puzzle().recursiveSearch(startPoint);
        aimPoint.asSolution();

    }

    public void concurrentShow() {
        new Puzzle().concurrentSearch(null);
    }

    /**
     *
     */
    public void compare() {
        HashSet<Point> points = new HashSet<PuzzleSolver.Point>();
        Point point1 = new Point(1, 1, null);
        Point point2 = new Point(2, 1, null);
        points.add(point1);
        points.add(point2);
        System.out.println(point1.equals(point2) + " " + points.size());
    }

    public static void main(String[] args) {
        new PuzzleSolver().sequentialShow();
//		new PuzzleSolver().compare();
        new PuzzleSolver().concurrentShow();


    }


    public class Puzzle {

        public Puzzle() {

        }

        public void recursiveSearch(Point point) {
            if (reachTheEnd(point)) {
                aimPoint = point;
                return;
            }
            List<Point> nextChildren = point.nextPoints();
            for (Point child : nextChildren) {
                if (point.isValid(child))
                    recursiveSearch(child);
            }
        }

        public void concurrentSearch(Point point) {
            exec.execute(new SolverTask(0, 1, null));
        }

        public boolean reachTheEnd(Point point) {
            return point.getX() == endPoint.getX() && point.getY() == endPoint.getY();
        }


        public class SolverTask extends Point implements Runnable {

            public SolverTask(int x, int y, Point father) {
                super(x, y, father);
            }

            public void run() {

                if (seen.putIfAbsent(this, true) != null)
                    return;
                if (reachTheEnd(this)) {
                    aimPoint = this;
                    System.out.println(aimPoint);
                    exec.shutdownNow();
                    return;
                }
                List<Point> nextChildren = this.nextPoints();
                for (Point child : nextChildren) {
                    if (this.isValid(child)) {
                        System.out.println(Thread.currentThread().getName() + ":" + child.getX() + child.getY());
                        exec.execute(new SolverTask(child.getX(), child.getY(), this));
                    }

                }

            }

        }
    }


    public class Point {
        private final int x;
        private final int y;
        private final Point father;

        public Point(int x, int y, Point father) {
            this.father = father;
            this.x = x;
            this.y = y;
        }

        public List<Point> nextPoints() {

            List<Point> childs = new LinkedList();
            childs.add(new Point(x - 1, y, this));
            childs.add(new Point(x + 1, y, this));
            childs.add(new Point(x, y - 1, this));
            childs.add(new Point(x, y + 1, this));

            return childs;
        }

        boolean isValid(Point point) {
            return !(isFather(point) || outOfBound(point) || isNot(point));
        }

        private boolean isFather(Point point) {
            if (father == null) return false;
            return point.getX() == father.getX() && point.getY() == father.getY();
        }

        private boolean outOfBound(Point point) {
            return point.getX() < 0 || point.getY() < 0 || point.getX() > map.length - 1 || point.getY() > map[0].length - 1;
        }

        private boolean isNot(Point point) {
            return map[point.getX()][point.getY()] == 1;
        }

        public void asSolution() {
            if (this.father == null)
                return;

            father.asSolution();
            System.out.println(this.getX() + "," + this.getY());
        }

        public int getX() {
            return x;
        }

        public int getY() {

            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass())
                return false;
            Point point = (Point) obj;
            return point.getX() == getX() && point.getY() == getY();
        }

        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return getX() << 16 + getY();
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", father=" + father + "]";
        }


    }


}
