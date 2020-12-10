import           System.IO
import qualified Data.Sequence as DS

main :: IO ()
main = do
  file <- readFile "input2.txt" 
  let solution1 = (show . solve  . parse) file 
      solution2 = (show . solve' . parse) file
  putStrLn $ "Solution 1: " ++ solution1
  putStrLn $ "Solution 2: " ++ solution2


solve :: [Int] -> Int
solve x = loop 0 $ DS.update 2 2 $ DS.update 1 12 $ DS.fromList x

solve' :: [Int] -> Int
solve' x = loopOuter 0 0 $ DS.fromList x 

loop :: Int -> DS.Seq Int -> Int
loop index list
  | op == 99  = DS.index list 0
  | op == 1   = loop nextIndex $ DS.update position (second + first) list
  | op == 2   = loop nextIndex $ DS.update position (second * first) list
  | otherwise = loop nextIndex list
  where
    nextIndex = index + 4
    op        = DS.index list index
    first     = DS.index list $ DS.index list $ index + 1
    second    = DS.index list $ DS.index list $ index + 2
    position  = DS.index list $ index + 3

loopOuter :: Int -> Int -> DS.Seq Int -> Int
loopOuter index1 index2 list
  | index1 < 100 = if (lookFor == loop 0 nList) then compute else loopOuter nIndex1 index2 nList
  | index1 > 100 = loopOuter 0 index2 nList
  | index2 < 100 = if (lookFor == loop 0 nList) then compute else loopOuter nIndex1 nIndex2 nList
  | otherwise    = error "otherwise clause"
  where
    nList   = DS.update 2 index2 $ DS.update 1 index1 list
    lookFor = 19690720 -- magic number to look for, it is based on my inputs
    compute = 100 * index1 + index2
    nIndex1 = index1 + 1
    nIndex2 = index2 + 1

parse :: String -> [Int]
parse = map read . split

split :: String -> [String]
split [] = [""]
split (c:cs)
  | c == ','  = "" : rest
  | otherwise = (c : head rest) : tail rest
    where rest = split cs
