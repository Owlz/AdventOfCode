import qualified Data.Set as DS
import Data.List
import Data.Maybe 
main :: IO ()
main = do
  file <- readFile "day3.txt" 
  let solution1 = (show . solve . parse . lines) file 
      solution2 = (show . solve' . parse . lines) file
  putStrLn $ "Solution 1: " ++ solution1
  putStrLn $ "Solution 2: " ++ solution2


solve :: ([Position], [Position]) -> Int
solve (listA, listB) = DS.findMin $ DS.map setSum $ DS.intersection setA setB
  where
    setA = DS.fromList listA
    setB = DS.fromList listB
    
    setSum :: Position -> Int
    setSum (f,s) = if(f + s == 0) then 99999 else f + s 

solve' :: ([Position], [Position]) -> Intersection
solve' (listA, listB) = mapped 
  where
    setA = DS.fromList listA
    setB = DS.fromList listB
    
    setTupleSum :: Position -> Intersection
    setTupleSum t@(f,s) = if(f + s == 0) then Intersection 99999 t else Intersection (stepsTo t listA + stepsTo t listB) t 

    mapped = DS.findMin $ DS.map setTupleSum $ DS.intersection setA setB
    
    stepsTo t l = (1+) $ fromJust $ elemIndex t l


parse :: [String] -> ([Position], [Position])
parse x = (stringParse $ x !! 0, stringParse $ x !! 1)
stringParse :: String -> [Position]
stringParse = parsePositions (0, 0) . split ','


parsePositions :: Position -> [String] -> [Position]
parsePositions p [] = []
parsePositions p (x:xs) = (rUnroll x p) ++ parsePositions (lastElem x p) xs
  where
    rUnroll x p = tail $ reverse $ unrollStr x p
    lastElem x p = last $ rUnroll x p

unrollStr :: String -> Position -> [Position]
unrollStr (x:xs) lastPos =
  let numb    = readInt xs
      nextVal = x : show (numb - 1)
      nextPos = oneStep x lastPos 
      in if (numb == 0) then [lastPos]
         else unrollStr nextVal nextPos ++ [lastPos]
  

oneStep :: Char -> Position -> Position
oneStep 'R' pos = (fst pos, 1 + snd pos)
oneStep 'L' pos = (fst pos, snd pos - 1)
oneStep 'U' pos = (1 + fst pos, snd pos)
oneStep 'D' pos = (fst pos - 1, snd pos)

readInt :: String -> Int
readInt = read

type Position = (Int, Int)
data Intersection = Intersection Int Position deriving (Show, Eq)
instance Ord Intersection where
  compare (Intersection i _) (Intersection i2 _) = compare i i2

split :: Char -> String -> [String]
split x [] = [""]
split x (c:cs)
  | c == x = "" : rest
  | otherwise = (c : head rest) : tail rest
    where rest = split x cs
