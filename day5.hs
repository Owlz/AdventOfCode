import           System.IO
import qualified Data.Sequence as DS
import           Debug.Trace (traceShow, traceShowId)

main :: IO ()
main = do
  file <- readFile "input5.txt" 
  let solution1 = (show . solve . parse) file 
      --solution2 = (show . solve' . parse) file
  putStrLn $ "Solution 1: " ++ solution1
  --putStrLn $ "Solution 2: " ++ solution2

solve :: [Int] -> Int
solve = loop 0 . DS.fromList  

loop :: Int -> DS.Seq Int -> Int
loop pos ls =
  let 
    lookup = DS.index ls
    fstVal a = if(a == 0) then lookup (lookup $ pos + 1) else lookup $ pos + 1
    sndVal a = if(a == 0) then lookup (lookup $ pos + 2) else lookup $ pos + 2 
    thdVal a = if(a == 0) then lookup $ pos + 3 else lookup $ pos + 3 
  in
    case lpad 5 0 $ digits $ lookup pos of
      [_, _, _, 9, 9] -> lookup 0
      [a, b, c, _, 1] -> loop (pos + 4) $ DS.update (thdVal a) (fstVal c + sndVal b) ls
      [a, b, c, _, 2] -> loop (pos + 4) $ DS.update (thdVal a) (fstVal c * sndVal b) ls
      [_, _, c, _, 3] -> loop (pos + 2) $ DS.update (fstVal c) 1 ls
      [_, _, c, _, 4] -> loop (pos + 2) $ traceShow (fstVal c) ls
      [_, _, _, _, _] -> loop (pos + 4) ls 

readInt :: String -> Int
readInt = read

data Mode = Position | Immediate

lpad :: Int -> a -> [a] -> [a]
lpad n pad xs = replicate (n - length xs) pad ++ xs

digits :: Int -> [Int]
digits n = map (\x -> read [x] :: Int) (show n)

parse :: String -> [Int]
parse = map read . split

split :: String -> [String]
split [] = [""]
split (c:cs)
  | c == ','  = "" : rest
  | otherwise = (c : head rest) : tail rest
    where rest = split cs
