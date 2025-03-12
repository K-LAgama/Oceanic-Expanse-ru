package com.sirsquidly.oe.util.handlers;

import com.sirsquidly.oe.Main;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Main.MOD_ID, name = Main.CONFIG_NAME)
@Config.LangKey("oe.config.title")
@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class ConfigHandler 
{
	@Config.LangKey("oe.config.worldGen")
	@Config.Comment("Config related to World Gen")
    public static configWorldGen worldGen = new configWorldGen();
	
	public static class configWorldGen
	{
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.coquinaOutcrop")
	    public configCoquinaOutcrop coquinaOutcrop = new configCoquinaOutcrop();
		
		public static class configCoquinaOutcrop
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableCoquinaOutcrops")
		    @Config.Comment("If Coquina Outcrops should be enabled")
		    public boolean enableCoquinaOutcrops = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.coquinaOutcropTriesPerChunk")
		    @Config.Comment("Coquina Outcrops tries per chunk to generate.")
		    public int coquinaOutcropTriesPerChunk = 1;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.coquinaOutcropChancePerChunk")
		    @Config.Comment("Coquina Outcrops chance to generate, per try. 1 / this number")
		    public int coquinaOutcropChancePerChunk = 3;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.kelpForest")
	    public configKelpForest kelpForest = new configKelpForest();
		
		public static class configKelpForest
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableKelpForest")
		    @Config.Comment("If Kelp Forests should be enabled")
		    public boolean enableKelpForest = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.kelpConnective")
		    @Config.Comment("The noise scale on the Kelp Forest. Smaller numbers make more interconnected noodles, while larger numbers make seperate clusters.")
		    public double kelpConnective = 0.2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.kelpSpread")
		    @Config.Comment("Adjusts the cutoff for the noise. Smaller numbers make the Kelp Forest more spread.")
		    public double kelpSpread = 0.1;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.kelpDensity")
		    @Config.Comment("The chance for Kelp to be placed in the forest")
		    public double kelpDensity = 0.2;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.frozenOcean")
	    public configFrozenOcean frozenOcean = new configFrozenOcean();
		
		public static class configFrozenOcean
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableFrozenOcean")
		    @Config.Comment("If Frozen Oceans should be enabled")
		    public boolean enableFrozenOcean = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableIceBerg")
		    @Config.Comment("If Icebergs should be enabled")
		    public boolean enableIcebergs = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableIceSheet")
		    @Config.Comment("If Ice Sheets should be enabled")
		    public boolean enableIceSheet = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.iceSheetSpread")
		    @Config.Comment("Adjusts the cutoff for the noise. Smaller numbers make the Ice Sheets more spread.")
		    public double iceSheetSpread = 0.3;
			
			@RequiresMcRestart
			@Config.LangKey("oe.config.worldGen.frozenSeafloor")
		    public configFrozenSeafloor frozenSeafloor = new configFrozenSeafloor();
			
			public static class configFrozenSeafloor
			{
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.enableRockDecor")
			    @Config.Comment("If Granite Chunks on the Frozen Ocean seafloor should be enabled")
			    public boolean enableRockDecor = true;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.seastarTriesPerChunk")
			    @Config.Comment("Seastar tries per chunk to generate.")
			    public int seastarTriesPerChunk = 6;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.seastarChancePerChunk")
			    @Config.Comment("Seastar chance to generate, per try. 1 / this number")
			    public int seastarChancePerChunk = 4;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.tubeSpongeTriesPerChunk")
			    @Config.Comment("Tube Sponge tries per chunk to generate.")
			    public int tubeSpongeTriesPerChunk = 1;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.tubeSpongeChancePerChunk")
			    @Config.Comment("Tube Sponge chance to generate, per try. 1 / this number")
			    public int tubeSpongeChancePerChunk = 3;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.dusleTriesPerChunk")
			    @Config.Comment("Dulse tries per chunk to generate.")
			    public int dusleTriesPerChunk = 2;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.dulseChancePerChunk")
			    @Config.Comment("Dulse chance to generate, per try. 1 / this number")
			    public int dulseChancePerChunk = 3;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.blueIceTriesPerChunk")
			    @Config.Comment("Blue Ice tries per chunk to generate.")
			    public int blueIceTriesPerChunk = 8;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.blueIceChancePerChunk")
			    @Config.Comment("Blue Ice chance to generate, per try. 1 / this number")
			    public int blueIceChancePerChunk = 2;
			}
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.warmOcean")
	    public configWarmOcean warmOcean = new configWarmOcean();
		
		public static class configWarmOcean
		{
			@RequiresMcRestart
			@Config.LangKey("oe.config.worldGen.coralReef")
		    public configCoralReef coralReef = new configCoralReef();
			
			public static class configCoralReef
			{
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.enableCoralReef")
			    @Config.Comment("If Coral Reefs should be enabled. Requires Warm Oceans.")
			    public boolean enableCoralReef = true;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.enableCoralStalk")
			    @Config.Comment("Enable Coral Stalks. The tree ones.")
			    public boolean enableCoralStalk= true;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.enableCoralBranch")
			    @Config.Comment("Enable Coral Branch/Claws. The sideways ones.")
			    public boolean enableCoralBranch= true;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.worldGen.enableCoralBulb")
			    @Config.Comment("Enable Coral Bulbs/Mushrooms. The round ones.")
			    public boolean enableCoralBulb= true;
			}
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableWarmOcean")
		    @Config.Comment("If Warm Oceans should be enabled")
		    public boolean enableWarmOcean = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.seaPickleTriesPerChunk")
		    @Config.Comment("The Sea Pickles' tries per chunk to generate.")
		    public int seaPickleTriesPerChunk = 1;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.seaPickleChancePerChunk")
		    @Config.Comment("The Sea Pickles' chance to generate, per try. 1 / this number")
		    public int seaPickleChancePerChunk = 6;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.palmTree")
	    public configPalmTree palmTree = new configPalmTree();
		
		public static class configPalmTree
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enablePalmTrees")
		    @Config.Comment("If Palm Trees should be enabled")
		    public boolean enablePalmTrees = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.palmTreeFullBark")
		    @Config.Comment("If the logs of Palm Trees should be full bark. Not to be confused with the Palm Wood block, they are still logs.")
		    public boolean palmTreeFullBark = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.palmTreeTriesPerChunk")
		    @Config.Comment("The Palm Trees' tries per chunk to generate.")
		    public int palmTreeTriesPerChunk = 3;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.palmTreeChancePerChunk")
		    @Config.Comment("The Palm Trees' chance to generate, per try. 1 / this number")
		    public int palmTreeChancePerChunk = 8;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.monumentPots")
	    public configMonumentPots monumentPots = new configMonumentPots();
		
		public static class configMonumentPots
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableMoumentPots")
		    @Config.Comment("If Prismarine Pots in Ocean Monuments should be enabled")
		    public boolean enableMoumentPots = true;
		}
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.worldGen.enableSeagrassPatches")
	    @Config.Comment("If Seagrass Patches should Generate")
	    public boolean enableSeagrassPatches = true;
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.seaOatsPatch")
	    public configSeaOatsPatch seaOatsPatch = new configSeaOatsPatch();
		
		public static class configSeaOatsPatch
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableSeaOatsPatch")
		    @Config.Comment("If Sea Oats Patches should Generate")
		    public boolean enableSeaOatsPatch = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.seaOatsPatchTriesPerChunk")
		    @Config.Comment("The Sea Oats Patches' tries per chunk to generate.")
		    public int seaOatsPatchTriesPerChunk = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.seaOatsPatchChancePerChunk")
		    @Config.Comment("The Sea Oats Patches' chance to generate, per try. 1 / this number")
		    public int seaOatsPatchChancePerChunk = 3;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.seaOatsPatchMinTallSides")
		    @Config.Comment("The minimum number of solid sides Tall Sea Oats require to be touching to generate.")
		    public int seaOatsPatchMinTallSides = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.seaOatsPatchChancePerChunk")
		    @Config.Comment("The chance to instead place Short Sea Oats if the spot does not pass the minimum solid sides. 1 / this number, setting to 0 disables the Short Sea Oat generation.")
		    public int seaOatsPatchShortChance = 3;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.shellPatch")
	    public configShellPatch shellPatch = new configShellPatch();
		
		public static class configShellPatch
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableShellPatch")
		    @Config.Comment("If Shell Patches should Generate")
		    public boolean enableShellPatch = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.shellPatchTriesPerChunk")
		    @Config.Comment("The Shell Patches' tries per chunk to generate.")
		    public int shellPatchTriesPerChunk = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.shellPatchChancePerChunk")
		    @Config.Comment("The Shell Patches' chance to generate, per try. 1 / this number")
		    public int shellPatchChancePerChunk = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.shellPatchAboveSeaLevel")
		    @Config.Comment("Blocks above Sea Level that Shell Patches can be placed.")
		    public int shellPatchAboveSeaLevel = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.shellPatchSeaStarChance")
		    @Config.Comment("Chance for a Sea Star to be placed atop a generated Shelly Sand.")
		    public int shellPatchSeaStarChance = 20;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.worldGen.shipwreck")
	    public configShipwreck shipwreck = new configShipwreck();
		
		public static class configShipwreck
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableShipwrecks")
		    @Config.Comment("If Shipwrecks should be enabled")
		    public boolean enableShipwrecks = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.enableShipwreckDrowned")
		    @Config.Comment("Makes Drowned spawn in groups in Shipwrecks when generated. There's 1 group per chest, making more complete shipwrecks more challenging.")
		    public boolean enableShipwreckDrowned = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.worldGen.shipwreckChancePerChunk")
		    @Config.Comment("The Shipwreck's chance to generate, per try. 1 / this number")
		    public int shipwreckChancePerChunk = 300;
		}
	}
	
	@Config.LangKey("oe.config.block")
	@Config.Comment("Config related to Blocks")
    public static configBlock block = new configBlock();
	
	public static class configBlock
	{
		@Config.LangKey("oe.config.block.blueIce")
	    public configBlueIce blueIce = new configBlueIce();
		
		public static class configBlueIce
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableBlueIce")
		    @Config.Comment("If Blue Ice is enabled")
		    public boolean enableBlueIce = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.blueIceLight")
		    @Config.Comment("How much Light Blue Ice gives off")
		    @Config.RangeDouble(min = 0, max = 16)
		    public double blueIceLight = 0;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.blueIceSlipperiness")
		    @Config.Comment("The slipperiness of Blue Ice")
		    @Config.RangeDouble(min = 0.6, max = 10)
		    public double blueIceSlipperiness = 0.989;
	    }
		
		@Config.LangKey("oe.config.block.conduit")
	    public configConduit conduit = new configConduit();
		
		public static class configConduit
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableConduit")
		    @Config.Comment("Enables the Conduit. Wait, why would you disable this?! It took me forever to make!")
		    public boolean enableConduit = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableConduitPulse")
		    @Config.Comment("Enables the pulsing animation for the Conduit Eye/Heart.")
		    public boolean enableConduitPulse = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.conduitLight")
		    @Config.Comment("How much Light the Conduit emits")
		    @Config.RangeDouble(min = 0, max = 16)
		    public double conduitLight = 14;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.conduitParticles")
		    @Config.Comment("The particles used by the Conduit when active or Attacking. (0 = None, 1 = Bedrock Runes, 2 = Java Eyes/Nautilus, 3 = Both, 4 = Yellow Bolt)")
		    @Config.RangeInt(min = 0, max = 18)
		    public double conduitParticles = 3;
			
			@Config.LangKey("oe.config.block.conduitFrameBlocks")
		    @Config.Comment("Blocks accepted by the Conduit as Frame Blocks.")
		    public String[] conduitFrameBlocks = {
		            "minecraft:prismarine",
					"minecraft:sea_lantern"
		    };
	    }
		
		@Config.LangKey("oe.config.block.coralBlocks")
	    public configCoralBlocks coralBlocks = new configCoralBlocks();
		
		public static class configCoralBlocks
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoralBlock")
		    @Config.Comment("Enables Coral Blocks")
		    public boolean enableCoralBlock = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoralFan")
		    @Config.Comment("Enables Coral Fans")
		    public boolean enableCoralFan = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoral")
		    @Config.Comment("Enabled Coral")
		    public boolean enableCoral = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coralBlockDryTicks")
		    @Config.Comment("World Ticks before Coral Blocks die. If set to 0, the coral will never die.")
		    public int coralBlockDryTicks = 100;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coralFanDryTicks")
		    @Config.Comment("World Ticks before Coral Fans die. If set to 0, the coral will never die.")
		    public int coralFanDryTicks = 100;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coralDryTicks")
		    @Config.Comment("World Ticks before Coral dies. If set to 0, the coral will never die.")
		    public int coralDryTicks = 100;
	    }
		
		@Config.LangKey("oe.config.block.coquina")
	    public configCoquina coquina = new configCoquina();
		
		public static class configCoquina
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoquina")
		    @Config.Comment("If Coquina is enabled")
		    public boolean enableCoquina = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoquinaBricks")
		    @Config.Comment("If Coquina Bricks, Coquina Brick Stairs, and Coquina Brick Slabs are enabled")
		    public boolean enableCoquinaBricks = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoquinaBrickWalls")
		    @Config.Comment("If Coquina Brick Walls are enabled. Requires Coquina Bricks to be enabled")
		    public boolean enableCoquinaBrickWalls = true;
	    }
		
		@Config.LangKey("oe.config.block.coconut")
	    public configCoconut coconut = new configCoconut();
		
		public static class configCoconut
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCoconut")
		    @Config.Comment("If Coconuts are enabled. This also enables Open Coconuts.")
		    public boolean enableCoconut = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coconutHitSound")
		    @Config.Comment("If coconuts go Clonk when hitting an entity")
		    public boolean coconutHitSound = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coconutFallBreak")
		    @Config.Comment("How many blocks a Coconut must fall to break. (-1 = Disabled entirely)")
		    @Config.RangeDouble(min = -1, max = 9999)
		    public double coconutFallBreak = 6.0;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coconutFallDamage")
		    @Config.Comment("How much damage per block added to a falling Coconut.")
		    @Config.RangeDouble(min = -1, max = 9999)
		    public double coconutFallDamage = 1.0;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.coconutFallMaxDamage")
		    @Config.Comment("How much max damage can a falling coconut deal")
			@Config.RangeInt(min = 0, max = 9999)
		    public int coconutFallMaxDamage = 19;
	    }
		
		@Config.LangKey("oe.config.block.dulse")
	    public configDulse dulse = new configDulse();
		
		public static class configDulse
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableDulse")
		    @Config.Comment("If Dulse is enabled. This also enables the Dried Dulse item and block.")
		    public boolean enableDulse = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.dulseShears")
		    @Config.Comment("If Shears can be used on Dulse to prevent it from growing. Sheared Dulse can be set back using bonemeal.")
		    public boolean dulseShears = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.driedDulseShears")
		    @Config.Comment("If the string on Dried Kelp can be removed using Shears.")
		    public boolean driedDulseShears = true;
	    }

		@Config.LangKey("oe.config.block.palmBlocks")
	    public configPalmBlocks palmBlocks = new configPalmBlocks();
		
		public static class configPalmBlocks
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enablePalmSapling")
		    @Config.Comment("If Palm Saplings are enabled.")
		    public boolean enablePalmSapling = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enablePalmLeaves")
		    @Config.Comment("If Palm Leaves are enabled. Flowering Palm Leaves require this and Coconuts to both be enabled.")
		    public boolean enablePalmLeaves = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enablePalmWoods")
		    @Config.Comment("If Palm Woods are enabled. Note this doesn't disable Palm Trees, they will generate using Jungle Wood.")
		    public boolean enablePalmWoods = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enablePalmStripping")
		    @Config.Comment("Adds the ability to strip Palm woods by using an Axe on it.")
		    public boolean enablePalmStripping = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enablePalmStrippedWoods")
		    @Config.Comment("If Stripped Palm Woods are enabled. Note this also disables Palm wood stripping.")
		    public boolean enablePalmStrippedWoods = true;
	    }
		
		@Config.LangKey("oe.config.block.pickledHead")
	    public configPickledHead pickledHead = new configPickledHead();
		
		public static class configPickledHead
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enablePickledHead")
		    @Config.Comment("If Pickled Heads are enabled.")
		    public boolean enablePickledHead = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.pickledHeadNoteblockSounds")
		    @Config.Comment("If a Pickled Head attached to a Note Block plays the Pickled's ambient sounds.")
		    public boolean pickledHeadNoteblockSounds = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.pickledHeadNoteblockPitch")
		    @Config.Comment("If pitch should be used by the Note Block. Requires the Note Block Behavior to be enabled.")
		    public boolean pickledHeadNoteblockPitch = true;
	    }
		
		@Config.LangKey("oe.config.block.guardianSpike")
	    public configGuardianSpike guardianSpike = new configGuardianSpike();
		
		public static class configGuardianSpike
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableGuardianSpike")
		    @Config.Comment("If the Guardian Spike is enabled")
		    public boolean enableGuardianSpike = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.guardianSpikeFallMultiplier")
		    @Config.Comment("How much a Guardian Spike multiplies Fall Damage.")
		    @Config.RangeDouble(min = 0, max = 9999)
		    public double guSpiFallMultiplier = 2.0;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.guardianSpikeDropChance")
		    @Config.Comment("The percent chance a Guardian drops a spike.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double guardianSpikeDropChance = 1;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.guardianSpikeLooting")
		    @Config.Comment("The percent increase per level of looting to the Guardian.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double guardianSpikeLooting = 0.5;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.guardianSpikeElderDropChance")
		    @Config.Comment("The percent chance an Elder Guardian drops a spike.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double guardianSpikeElderDropChance = 100;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.guardianSpikeElderLooting")
		    @Config.Comment("The percent increase per level of looting to the Elder Guardian.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double guardianSpikeElderLooting = 0;
	    }
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.block.enableKelp")
	    @Config.Comment("If Kelp is enabled")
	    public boolean enableKelp = true;
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.block.driedKelpShears")
	    @Config.Comment("If the string on Dried Kelp can be removed using Shears")
	    public boolean driedKelpShears = true;
		
		@Config.LangKey("oe.config.block.seagrass")
	    public configSeagrass seagrass = new configSeagrass();
		
		public static class configSeagrass
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableSeagrass")
		    @Config.Comment("If Seagrass is enabled")
		    public boolean enableSeagrass = true;
		    
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableTallSeagrass")
		    @Config.Comment("If Tall Seagrass is enabled")
		    public boolean enableTallSeagrass = true;
	    }
		
		@Config.LangKey("oe.config.block.seaOats")
	    public configSeaOats seaOats = new configSeaOats();
		
		public static class configSeaOats
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableSeaOats")
		    @Config.Comment("If Sea Oats are enabled")
		    public boolean enableSeaOats = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.seaOatShears")
		    @Config.Comment("If Sea Oats can be sheared down to their short version.")
		    public boolean seaOatShears = true;
	    }
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.block.enableSeaPickle")
	    @Config.Comment("If Sea Pickles are enabled")
	    public boolean enableSeaPickle = true;	
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.block.enableSeastar")
	    @Config.Comment("If Seastars are enabled")
	    public boolean enableSeastar = true;
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.block.enableShellySand")
	    @Config.Comment("If Shelly Sand is enabled")
	    public boolean enableShellySand = true;

		@Config.LangKey("oe.config.block.stagnant")
		public configStagnant stagnant = new configStagnant();

		public static class configStagnant
		{
			@RequiresMcRestart
			@Config.LangKey("oe.config.block.enableStagnant")
			@Config.Comment("Enables the Stagnant.")
			public boolean enableStagnant = true;

			@RequiresMcRestart
			@Config.LangKey("oe.config.block.stagnantLight")
			@Config.Comment("How much Light the Stagnant emits")
			@Config.RangeDouble(min = 0, max = 16)
			public double stagnantLight = 14;

			@RequiresMcRestart
			@Config.LangKey("oe.config.block.stagnantParticles")
			@Config.Comment("The particles used by the Stagnant when active or Attacking. (0 = None, 1 = Bedrock Runes, 2 = Java Eyes/Nautilus, 3 = Both, 4 = Yellow Bolt)")
			@Config.RangeInt(min = 0, max = 18)
			public double stagnantParticles = 3;

			@Config.LangKey("oe.config.block.stagnantFrameBlocks")
			@Config.Comment("Blocks accepted by the Stagnant as Frame Blocks.")
			public String[] stagnantFrameBlocks = {
					"minecraft:prismarine",
					"minecraft:sea_lantern"
			};

			@Config.LangKey("oe.config.block.stagnantIgnoreTargets")
			@Config.Comment("Entities the the Stagnant will ignore. EVERY entity extending EntityLivingBase is targeted, unless specified here.")
			public String[] stagnantIgnoreTargets = {
					"minecraft:armor_stand",
					"minecraft:guardian",
					"minecraft:elder_guardian",
					"oe:drowned"
			};
		}

		@Config.LangKey("oe.config.block.tubeSponge")
	    public configTubeSponge tubeSponge = new configTubeSponge();
		
		public static class configTubeSponge
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableTubeSponge")
		    @Config.Comment("If Tube Sponges are enabled")
		    public boolean enableTubeSponge = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.tubeSpongeShears")
		    @Config.Comment("If Shears can be used on Tube Sponge to prevent it from growing.")
		    public boolean tubeSpongeShears = true;
	    }
		
		@Config.LangKey("oe.config.block.turtleEggs")
	    public configTurtleEgg turtleEgg = new configTurtleEgg();
		
		public static class configTurtleEgg
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableTurtleEgg")
		    @Config.Comment("If Turtle Eggs are enabled. If disabled, breeding turtles will just create a baby directly, like normal mob breeding.")
		    public boolean enableTurtleEgg = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.amountOnTrample")
		    @Config.Comment("Amount of Turtle Eggs broken each time the trampleAI succeeds.")
		    @Config.RangeInt(min = 0, max = 4)
		    public int amountOnTrample = 1;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.particlesOnFall")
		    @Config.Comment("If egg shell particles spawn when fallen on. (0 = Never, 1 = By AI, 2 = Always)")
		    @Config.RangeInt(min = 0, max = 2)
		    public int particlesOnFall = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.puffOnTrample")
		    @Config.Comment("If puff particles spawn when trampled. (0 = Never, 1 = By AI, 2 = Always)")
		    @Config.RangeInt(min = 0, max = 2)
		    public int puffOnTrample = 2;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.zombiesTrample")
		    @Config.Comment("If any mob extending Zombie (Zombie, Husks, Drowned, ect) are given the trampleAI")
		    public boolean zombiesTrample = true;
	    }
		
		@Config.LangKey("oe.config.block.waterTorch")
	    public configUnderwaterTorch waterTorch = new configUnderwaterTorch();
		
		public static class configUnderwaterTorch
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableWaterTorch")
		    @Config.Comment("If Underwater Torches are enabled")
		    public boolean enableWaterTorch = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.waterTorchLight")
		    @Config.Comment("How much Light the Underwater Torch gives off")
		    @Config.RangeDouble(min = 0, max = 16)
		    public double waterTorchLight = 14;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.waterTorchParticles")
		    @Config.Comment("The particles of the Underwater Torch. (0 = None, 1 = Glow Squid Glow, 2 = Firework Sparks, 3 = Both)")
		    @Config.RangeDouble(min = 0, max = 3)
		    public double waterTorchParticles = 1;
	    }
	}
	
	@Config.LangKey("oe.config.item")
	@Config.Comment("Config related to Items, Tools, ect")
    public static configItem item = new configItem();
	
	public static class configItem
	{
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.bisque")
	    public configBisque bisque = new configBisque();
		
		public static class configBisque
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableBisqueMilkEffect")
		    @Config.Comment("If Bisques remove all Potion Effects. This is here because Milk is used to craft Bisque.")
		    public boolean enableBisqueMilkEffect = false;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableCrabBisque")
		    @Config.Comment("If Crab Bisque is enabled.")
		    public boolean enableCrabBisque = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableLobsterBisque")
		    @Config.Comment("If Lobster Bisque is enabled.")
		    public boolean enableLobsterBisque = true;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.conch")
	    public configConch conch = new configConch();
		
		public static class configConch
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.block.enableConch")
		    @Config.Comment("If Conches are enabled. This WILL break Shelly Sand if disabled.")
		    public boolean enableConch = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.conchCooldown")
		    @Config.Comment("The default cooldown between uses of the Conch. Can be altered per-conch using the 'Cooldown' NBT tag.")
			@Config.RangeInt(min = 0, max = 9999)
		    public int conchCooldown = 60;
		
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.conchSoundDistance")
		    @Config.Comment("The attenuation distance of the Conch, how far away it's heard from.")
			@Config.RangeInt(min = 0, max = 9999)
		    public int conchSoundDistance = 256;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.conchDisplayHorn")
		    @Config.Comment("Adds description text to the Conch to tell which Horn sound is attached to it. Only for the default horn sounds.")
		    public boolean conchDisplayHorn = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.conchDisplayRawSound")
		    @Config.Comment("Adds the attached sound's registry name to the Conch's description. Overridden by 'conchDisplayHorn' if the sound is a horn sound.")
		    public boolean conchDisplayRawSound = true;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.conduitCharm")
	    public configConduitCharm conduitCharm = new configConduitCharm();
		
		public static class configConduitCharm
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableConduitCharm")
		    @Config.Comment("If the Charm is enabled.")
		    public boolean enableConduitCharm = true;
		
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.conduitCharmConduitRange")
		    @Config.Comment("The radius that Conduit Power is given to nearby Players. Setting to 0 makes only the holder be affected.")
			@Config.RangeInt(min = 0, max = 9999)
		    public int conduitCharmConduitRange = 16;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableConduitCharmPulseSound")
		    @Config.Comment("If the Charm makes a Conduit Pulse each time it applies the effect.")
		    public boolean enableConduitCharmPulseSound = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.conduitCharmDurability")
		    @Config.Comment("The durability of the Charm. Each time it applies Conduit Power, the durability goes down by 1, making this a timer for the item.")
			@Config.RangeInt(min = 0, max = 9999)
		    public int conduitCharmDurability = 30;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.glowItemFrame")
	    public configGlowItemFrame glowItemFrame = new configGlowItemFrame();
		
		public static class configGlowItemFrame
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableGlowItemFrame")
		    @Config.Comment("If Glow Item Frames are enabled.")
		    public boolean enableGlowItemFrame = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.glowItemFrameCeilingsAndFloors")
		    @Config.Comment("If Glow Item Frames can be placed on Ceilings and Floors.")
		    public boolean glowItemFrameCeilingsAndFloors = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.glowItemFrameQuarkNamePosition")
		    @Config.Comment("If ceilings or floors Glow Item Frames render custom item names at the same spots as Quark. Otherwise uses Vanilla name positions.")
		    public boolean glowItemFrameQuarkNamePosition = true;
		}
		
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.heavyBoots")
	    public configHeavyBoots heavyBoots = new configHeavyBoots();
		
		public static class configHeavyBoots
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableHeavyBoots")
		    @Config.Comment("If Heavy Boots are enabled")
		    public boolean enableHeavyBoots= true;
			
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.item.heavyBootsEffectLength")
		    @Config.Comment("How long (in seconds) Descent is given.")
		    public int heavyBootsEffectLength = 10;
		    
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.heavyBootsDesc")
		    @Config.Comment("Heavy Boots have a description.")
		    public boolean heavyBootsDesc = true;
	    }
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.item.enableNautilusShell")
	    @Config.Comment("If Nautilus Shells are enabled. This WILL break Shelly Sand if disabled.")
	    public boolean enableNautilusShell= true;
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.pearl")
	    public configPearl pearl = new configPearl();
		
		public static class configPearl
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enablePearl")
		    @Config.Comment("If Pearls are enabled")
		    public boolean enablePearl = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enablePearlTrade")
		    @Config.Comment("Adds a Pearl Trade to the Fisherman Villager")
		    public boolean enablePearlTrade = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enablePearlEndering")
		    @Config.Comment("Makes a Pearl turn into an Ender Pearl when held and eating Chorus Fruit.")
		    public boolean enablePearlEndering = true;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.spawnBucket")
	    public configSpawnBucket spawnBucket = new configSpawnBucket();
		
		public static class configSpawnBucket
		{
			@Config.LangKey("oe.config.item.spawnBucketMobs")
		    @Config.Comment("Mobs that can be bucketed. These will also appear in Creative Tabs.")
		    public String[] bucketableMobs = 
			{
				 	"oe:baby_squid",
				 	"oe:baby_glow_squid",
				 	"oe:cod",
				 	"oe:salmon",
				 	"oe:pufferfish",
				 	"oe:tropical_fish",
				 	"oe:crab",
				 	"oe:lobster"
		    };
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.spawnBucketTropicalFishSpecificNames")
		    @Config.Comment("If buckets of tropical fish add the fish's colors and type to the bucket name (ex 'Bucket of White Kob'). Note this does not override if the fish already has a custom name.")
		    public boolean spawnBucketTropicalFishSpecificNames = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.spawnBucketTropicalFishTooltips")
		    @Config.Comment("If buckets of tropical fish add the fish's colors and type in a tooltip.")
		    public boolean spawnBucketTropicalFishTooltips = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableAllBucketsCreative")
		    @Config.Comment("Makes every possible spawn bucket appear in the creative search tab. Warning, this is equal to every spawn egg, and most won't have proper textures!")
		    public boolean enableAllBucketsCreative = false;
			
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableSpawnBucketEmptyUsage")
		    @Config.Comment("Allows empty buckets to be used to bucket mobs. This is true in Bedrock Edition.")
		    public boolean enableSpawnBucketEmptyUsage = false;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.item.spongeChunk")
	    public configSpongeChunk spongeChunk = new configSpongeChunk();
		
		public static class configSpongeChunk
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableSpongeChunk")
		    @Config.Comment("If the Sponge Chunk is enabled.")
		    public boolean enableSpongeChunk = true;
		
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.spongeChunkAbsorbRadius")
		    @Config.Comment("The radius that the Sponge Chunk picks up Water.")
			@Config.RangeInt(min = 0, max = 100)
		    public int spongeChunkAbsorbRadius = 5;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.spongeChunkMaxSaturation")
		    @Config.Comment("The max Saturation(water) a Sponge Chunk can hold. Seeting to 0 Disables water collecting, while -1 makes it infinite!")
			@Config.RangeInt(min = -1, max = 9999)
		    public int spongeChunkMaxSaturation = 30;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.trident")
	    public configTrident trident = new configTrident();
		
		public static class configTrident
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableTrident")
		    @Config.Comment("If Tridents are enabled")
		    public boolean enableTrident = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableTridentCrafting")
		    @Config.Comment("If Tridents can be crafted. Requires Guardian Spikes to also be enabled.")
		    public boolean enableTridentCrafting = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.tridentPreventThrowBreak")
		    @Config.Comment("A safeguard preventing the player from throwing a Trident at 1 durability, as it would break on impact. This safeguard is in Vanilla Minecraft.")
		    public boolean tridentPreventThrowBreak = true;
			
		    @Config.LangKey("oe.config.item.tridentDamage")
		    @Config.Comment("The Attack Damage of the Trident")
		    public int tridentDamage = 9;
			
		    @Config.LangKey("oe.config.item.tridentThrowDamage")
		    @Config.Comment("The Attack Damage of the Thrown Trident")
		    public int tridentThrowDamage = 8;
			
		    @Config.LangKey("oe.config.item.tridentAttackSpeed")
		    @Config.Comment("The Attack Speed of the Trident")
		    public double tridentSpeed = 1.1;
			
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.item.tridentDurability")
		    @Config.Comment("The Trident's Durability (note, displays as this -1 in-game, as 0 counts as a point)")
		    public int tridentDurability = 250;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.item.trident3PsnAnimStyle")
		    @Config.Comment("The style of 3ed person animations the Trident uses. (0 = None, 1 = Vanilla, 2 = Oceanic Expanse)")
			@Config.RangeInt(min = 0, max = 2)
		    public int trident3PsnAnimStyle = 2;
	    }
		
		@RequiresMcRestart
	    @Config.LangKey("oe.config.item.enableTurtleScute")
	    @Config.Comment("If Turtle Scutes are enabled. This WILL break Shelly Sand if disabled.")
	    public boolean enableTurtleScute= true;
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.turtleShell")
	    public configTurtleShell turtleShell = new configTurtleShell();
		
		public static class configTurtleShell
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableTurtleShell")
		    @Config.Comment("If Turtle Shells are enabled")
		    public boolean enableTurtleShell= true;
			
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.item.turtleShellEffectLength")
		    @Config.Comment("How long (in seconds) Water Breathing is given.")
		    public int turtleShellEffectLength = 10;
		    
			@RequiresMcRestart
		    @Config.LangKey("oe.config.item.enableTurtleShellDesc")
		    @Config.Comment("Turtle Shell has a description.")
		    public boolean enableTurtleShellDesc = true;
	    }
	}
	
	@Config.LangKey("oe.config.entity")
	@Config.Comment("Config related to Entities")
    public static configEntity entity = new configEntity();
	
	public static class configEntity
	{
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.babySquid")
	    public configBabySquid babySquid = new configBabySquid();
		
		public static class configBabySquid
		{
		    @Config.LangKey("oe.config.entity.enableBabySquid")
		    @Config.Comment("If Baby Squids should be enabled")
		    public boolean enableBabySquid = true;
		    
		    @Config.LangKey("oe.config.entity.babySquidCustomModel")
		    @Config.Comment("If Baby Squids should use a custom model and texture. If disabled, they will instead just use a shrunk version of the vanilla Squid model.")
		    public boolean babySquidCustomModel = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.babySquidSpawnChance")
		    @Config.Comment("The percent chance for a Baby Squid to spawn along-side an adult squid.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double babySquidSpawnChance = 14.3;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.babyGlowSquid")
	    public configBabyGlowSquid babyGlowSquid = new configBabyGlowSquid();
		
		public static class configBabyGlowSquid
		{
		    @Config.LangKey("oe.config.entity.enableBabyGlowSquid")
		    @Config.Comment("If Baby Glow Squids should be enabled")
		    public boolean enableBabyGlowSquid = true;
		    
		    @Config.LangKey("oe.config.entity.babyGlowSquidCustomModel")
		    @Config.Comment("If Baby Glow Squids should use a custom model and texture. If disabled, they will instead just use a shrunk version of the vanilla Squid model.")
		    public boolean babyGlowSquidCustomModel = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.babyGlowSquidSpawnChance")
		    @Config.Comment("The percent chance for a Baby Glow Squid to spawn along-side an adult glow squid.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double babyGlowSquidSpawnChance = 14.3;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.clam")
	    public configClam clam = new configClam();
		
		public static class configClam
		{
		    @Config.LangKey("oe.config.entity.enableClam")
		    @Config.Comment("If Clams should be enabled")
		    public boolean enableClam = true;

			@RequiresMcRestart
			@Config.LangKey("oe.config.entity.clamBiomineralizationList")
			@Config.Comment("Converts items held within a Clam. Written as 'blockID/itemID:metadata' = 'converstionTime' = 'resulting blockID/itemID:metadata'.")
			public String[] clamBiomineralizationList =
					{
							"minecraft:gravel=10=minecraft:sand",
							"minecraft:sand:1=40=oe:pearl",
							"minecraft:sand=40=oe:pearl",
							"oe:shell_sand=5=oe:pearl"
					};
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.cod")
	    public configCod cod = new configCod();
		
		public static class configCod
		{
		    @Config.LangKey("oe.config.entity.enableCod")
		    @Config.Comment("If Cod should be enabled")
		    public boolean enableCod = true;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.crab")
	    public configCrab crab = new configCrab();
		
		public static class configCrab
		{
		    @Config.LangKey("oe.config.entity.enableCrab")
		    @Config.Comment("If Crabs should be enabled")
		    public boolean enableCrab = true;
		    
		    @Config.LangKey("oe.config.entity.crabTalkInterval")
		    @Config.Comment("The number to ticks between the crab's chirps (ambient sound). 0 disables it, if you hate their chirps.")
		    public int crabTalkInterval = 280;
		    
		    @Config.LangKey("oe.config.entity.enableCrabDigging")
		    @Config.Comment("If Crabs can dig. Does not affect the individual crabs that have 'CanDig' set to false.")
		    public boolean enableCrabDigging = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.crabDiggingList")
		    @Config.Comment("Allows a Crab to dig from certain blocks, and the Loot Table they will pull from.")
		    public String[] crabDiggingList =
			{
		    	"minecraft:gravel=oe:gameplay/crab_dig/gravel",
		    	"minecraft:sand:1=oe:gameplay/crab_dig/red_sand",
		    	"minecraft:sand=oe:gameplay/crab_dig/sand",
		    	"oe:shell_sand=oe:gameplay/crab_dig/shelly_sand",
		    	"minecraft:soul_sand=oe:gameplay/crab_dig/soul_sand"
		    };
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.glowSquid")
	    public configGlowSquid glowSquid = new configGlowSquid();
		
		public static class configGlowSquid
		{
		    @Config.LangKey("oe.config.entity.glowSquidBodyBright")
		    @Config.Comment("Minimum brightness of Glow Squids. 15 is Full Bright")
		    public int glowSquidBodyBright = 4;
			
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.glowSquidLayer")
		    @Config.Comment("If Glow Squids should have a 2ed layer for brightness")
		    public boolean glowSquidLayer = true;
		    
		    @Config.LangKey("oe.config.entity.glowSquidLayerBright")
		    @Config.Comment("Brightness of a Glow Squids' second layer. 15 is Full Bright")
		    public int glowSquidLayerBright = 11;
		    
		    @Config.LangKey("oe.config.entity.glowSquidSpawnMaxHeight")
		    @Config.Comment("The Maximum spawn height of the Glow Squid")
		    public int glowSquidSpawnMaxHeight = 40;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.lobster")
	    public configLobster lobster = new configLobster();
		
		public static class configLobster
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableLobster")
		    @Config.Comment("If Lobster should be enabled")
		    public boolean enableLobster = true;
			
			@Config.LangKey("oe.config.entity.lobsterMoltCooldown")
		    @Config.Comment("The cooldown between when a Lobster can Molt again. Lowers per tick, so 20:1 second. Default is 3000(2.5 minutes).")
		    public int lobsterMoltCooldown = 3000;
		    
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.pickled")
	    public configPickled pickled = new configPickled();
		
		public static class configPickled
		{
		    @Config.LangKey("oe.config.entity.enablePickled")
		    @Config.Comment("If Pickled should be enabled")
		    public boolean enablePickled = true;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.pufferfish")
	    public configPufferfish pufferfish = new configPufferfish();
		
		public static class configPufferfish
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enablePufferfish")
		    @Config.Comment("If Pufferfish should be enabled")
		    public boolean enablePufferfish = true;
		    
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enablePufferfishInflateOnHit")
		    @Config.Comment("Pufferfish instantly inflate to full when hurt")
		    public boolean enablePufferfishInflateOnHit = true;
			
		    @Config.LangKey("oe.config.entity.pufferfishFriends")
		    @Config.Comment("Mobs that don't scare the Pufferfish.")
		    public String[] pufferfishFriends = 
			{
				 	"minecraft:squid",
				 	"oe:baby_squid",
				 	"oe:baby_glow_squid",
				 	"oe:cod",
				 	"oe:lobster",
				 	"oe:salmon",
				 	"oe:pufferfish",
				 	"oe:tropical_fish",
				 	"oe:turtle",
				 	"oe:glow_squid",
				 	"oe:clam"
		    };
		    
		    @Config.LangKey("oe.config.entity.pufferfishPoisonLength")
		    @Config.Comment("How long the Pufferfish Poison lasts.")
		    public int pufferfishPoisonLength = 6;
		    
		    @Config.LangKey("oe.config.entity.pufferfishPoisonAmplifier")
		    @Config.Comment("The amplifier of the Pufferfish Poison.")
		    public int pufferfishPoisonAmplifier = 1;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.salmon")
	    public configSalmon salmon = new configSalmon();
		
		public static class configSalmon
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableSalmon")
		    @Config.Comment("If Slamon should be enabled")
		    public boolean enableSalmon = true;
			
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.salmonSizeVarience")
		    @Config.Comment("If Salmon can spawn in a variety of sizes.")
		    public boolean salmonSizeVarience = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.salmonFeedingGrowth")
		    @Config.Comment("When using breeding items on Salmon, they grow in size. This is a joke feature.")
		    public boolean salmonFeedingGrowth = false;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.tropicalFish")
	    public configTropicalFish tropicalFish = new configTropicalFish();
		
		public static class configTropicalFish
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableTropicalFish")
		    @Config.Comment("If Tropical Fish should be enabled")
		    public boolean enableTropicalFish = true;
		    
			@Config.LangKey("oe.config.entity.tropicalFishDefaultChance")
		    @Config.Comment("The percent chance a tropical fish is from the default variants list.")
		    public int tropicalFishDefaultChance = 90;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.tropicalFishBedrockColors")
		    @Config.Comment("If Tropical fish colors should use bedrock names. [Light Blue -> Sky, Pink -> Rose, Light Gray -> Silver, Cyan -> Teal, Purple -> Plum]")
		    public boolean tropicalFishBedrockColors = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableBlackTropicalFish")
		    @Config.Comment("If Black should be included in the list of possible tropical fish colors. This is not in vanilla Minecraft, as it makes the fish eyes hard to see.")
		    public boolean enableBlackTropicalFish = false;
			
		    @Config.LangKey("oe.config.entity.defaultTropicalFishVariants")
		    @Config.Comment("The most likely list of tropical fish variants to spawn")
		    public String[] defaultTropicalFishVariants = 
			{
				 	"65536",
				 	"459008",
				 	"917504",
				 	"918273",
				 	"918529",
				 	"16778497",
				 	"50660352",
				 	"50726144",
				 	"67108865",
				 	"67110144",
				 	"67371009",
				 	"67699456",
				 	"67764993",
				 	"101253888",
				 	"117441025",
				 	"117441793",
				 	"117506305",
				 	"117899265",
				 	"118161664",
				 	"185008129",
				 	"234882305",
				 	"235340288"
		    };
		    
		    @Config.LangKey("oe.config.entity.tropicalFishNameOverrides")
		    @Config.Comment("Assigns unique names for certain Tropical Fish. Accepts Translation Keys or Raw String.")
		    public String[] tropicalFishNameOverrides = 
			{
				 	"65536=description.oe.tropical_fish.65536.name",
				 	"459008=description.oe.tropical_fish.459008.name",
				 	"917504=description.oe.tropical_fish.917504.name",
				 	"918273=description.oe.tropical_fish.918273.name",
				 	"918529=description.oe.tropical_fish.918529.name",
				 	"16778497=description.oe.tropical_fish.16778497.name",
				 	"50660352=description.oe.tropical_fish.50660352.name",
				 	"50726144=description.oe.tropical_fish.50726144.name",
				 	"67108865=description.oe.tropical_fish.67108865.name",
				 	"67110144=description.oe.tropical_fish.67110144.name",
				 	"67371009=description.oe.tropical_fish.67371009.name",
				 	"67699456=description.oe.tropical_fish.67699456.name",
				 	"67764993=description.oe.tropical_fish.67764993.name",
				 	"101253888=description.oe.tropical_fish.101253888.name",
				 	"117441025=description.oe.tropical_fish.117441025.name",
				 	"117441793=description.oe.tropical_fish.117441793.name",
				 	"117506305=description.oe.tropical_fish.117506305.name",
				 	"117899265=description.oe.tropical_fish.117899265.name",
				 	"118161664=description.oe.tropical_fish.118161664.name",
				 	"185008129=description.oe.tropical_fish.185008129.name",
				 	"234882305=description.oe.tropical_fish.234882305.name",
				 	"235340288=description.oe.tropical_fish.235340288.name"
		    };
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.tropical_slime")
	    public configTropicalSlime tropicalSlime = new configTropicalSlime();
		
		public static class configTropicalSlime
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableTropicalSlime")
		    @Config.Comment("If Tropical Slimes should be enabled")
		    public boolean enableTropicalSlime = true;
		    
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableJungleTropicalSlime")
		    @Config.Comment("If Tropical Slimes can spawn in Jungles. Follows the same rules Slimes do in Swamps.")
		    public boolean tropicalSlimeJungleSpawning = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.tropicalSlimeBucketKill")
		    @Config.Comment("Allows the player to scoop the Fish out of a medium or small Tropical Slime usong a Bucket. This kills the Slime.")
		    public boolean tropicalSlimeBucketKill = true;
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.turtle")
	    public configTurtle turtle = new configTurtle();
		
		public static class configTurtle
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableTurtle")
		    @Config.Comment("If Turtles should be enabled")
		    public boolean enableTurtle = true;
		    
			@Config.LangKey("oe.config.entity.turtleBreedCooldown")
		    @Config.Comment("How many seconds before a Turtle can breed again. For refrence, the Turtle Breeding cooldowns are 90 seconds in Bedrock, 300 (standard 5 minutes) in Java.")
		    public int turtleBreedCooldown = 90;
			
		    @Config.LangKey("oe.config.entity.babyTurtlePredators")
		    @Config.Comment("These mobs will attack baby turtles. If the mob is tamable (such as a wolf or ocelot), they will only attack if they are untamed.")
		    public String[] babyTurtlePredators = 
			{
				 	"minecraft:zombie",
				 	"minecraft:husk",
				 	"minecraft:skeleton",
				 	"minecraft:stray",
				 	"minecraft:wither_skeleton",
				 	"minecraft:wolf",
				 	"minecraft:ocelot",
				 	"oe:drowned",
				 	"oe:pickled"
		    };
		}
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.entity.drowned")
	    public configDrowned drowned = new configDrowned();
		
		public static class configDrowned
		{
			@RequiresMcRestart
			@Config.LangKey("oe.config.entity.drownedCaptain")
		    public configDrownedCaptain drownedCaptain = new configDrownedCaptain();
			
			public static class configDrownedCaptain
			{
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.enableDrownedCaptain")
			    @Config.Comment("If Drowned Captains should be enabled. Captains are just altered Drowned, so this just skips the checks.")
			    public boolean enableDrownedCaptain = true;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.drownedCaptainSetChance")
			    @Config.Comment("The chance for a drowned to be a drowned captain. Calculated as '(this x Clamped Regional Difficulty)%'")
				@Config.RangeDouble(min = 0, max = 100)
			    public double drownedCaptainSetChance = 5;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.enableDrownedCaptainTexture")
			    @Config.Comment("If Drowned Captains should use a unique texture.")
			    public boolean enableDrownedCaptainTexture = true;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.drownedCaptainSummonCooldown")
			    @Config.Comment("The time (in seconds) between when the Drowned Captain is allowed to spawn more drowned. Note 0 will not disable this, but make it near instant.")
			    @Config.RangeDouble(min = 0, max = 9999)
			    public double drownedCaptainSummonCooldown = 10;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.drownedCaptainHealthMultiplier")
			    @Config.Comment("The multiplier on the Drowned Captain's health. This is multiplied by the base drowned health, which is 20 by default.")
			    @Config.RangeDouble(min = 0, max = 9999)
			    public double drownedCaptainHealthMultiplier = 2;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.drownedCaptainMaxNearbyForSummon")
			    @Config.Comment("Stops the Drowned Captain from summoning if above this number of drowned are nearby.")
			    public int drownedCaptainMaxNearbyForSummon = 5;
				
				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.drownedCaptainEquippedSpawns")
			    @Config.Comment("If drowned spawned by a captain have their normal setup. This allows them to have trident, be babies, or even be MORE CAPTAINS!")
			    public boolean drownedCaptainEquippedSpawns = false;

				@RequiresMcRestart
			    @Config.LangKey("oe.config.entity.drownedCaptainConchSoundDistance")
			    @Config.Comment("The attenuation distance (how far away it's heard) of the Conch when used by the captain.")
				@Config.RangeInt(min = 0, max = 9999)
			    public int drownedCaptainConchSoundDistance = 256;
			}
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableDrowned")
		    @Config.Comment("If Drowned should be enabled")
		    public boolean enableDrowned = true;
			
		    @Config.LangKey("oe.config.entity.enableDrownedSwimAnims")
		    @Config.Comment("Enables unique animations for Drowned in water, inspired by MC Dungeons.")
		    public boolean enableDrownedSwimAnims = true;
			
		    @Config.LangKey("oe.config.entity.enableDrownedLowerArms")
		    @Config.Comment("Makes drowned lower their arms if they have an item in their off hand. This is to match Bedrock Edition.")
		    public boolean enableDrownedLowerArms = false;
		    
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableDrownedStepup")
		    @Config.Comment("If Drowned keep a full block step-up outside of water.")
		    public boolean enableDrownedStepup = false;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.drownedArmorSpawning")
		    @Config.Comment("If Drowned can spawn wearing Armor the same way normal Zombies do.")
		    public boolean drownedArmorSpawning = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.drownedTridentSpawnChance")
		    @Config.Comment("The percent chance a Drowned spawns holding a Trident.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double drownedTridentSpawnChance = 6.25;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.drownedRodSpawnChance")
		    @Config.Comment("The percent chance a Drowned spawns holding a Fishing Rod. Note this will always run after the Trident check, so this will never replace a Trident spawn.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double drownedRodSpawnChance = 3.75;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.drownedNautilusSpawnChance")
		    @Config.Comment("The percent chance a Drowned spawns holding a Nautilus Shell in its offhand.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double drownedNautilusSpawnChance = 3;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.drownedTridentMeleeRange")
		    @Config.Comment("The distance (in blocks) in which a Trident Drowned will use melee rather than ranged attacks.")
		    @Config.RangeDouble(min = 0, max = 100)
		    public double drownedTridentMeleeRange = 3;
			
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.entity.drownedGlowLayer")
		    @Config.Comment("If Drowned should have a 2ed layer for brightness")
		    public boolean drownedGlowLayer = true;
	    }
	}
	
	
	@Config.LangKey("oe.config.enchant")
	@Config.Comment("Config related to Enchantments")
    public static configEnchantment enchant = new configEnchantment();
	
	public static class configEnchantment
	{
		@Config.LangKey("oe.config.enchant.channeling")
		@Config.Comment("Config for Channeling")
	    public configChanneling channeling = new configChanneling();
		
		public static class configChanneling
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableChannelingEnchant")
		    @Config.Comment("If the Channeling Enchantment should be enabled.")
		    public boolean enableChannelingEnchant = true;
			
		    @Config.LangKey("oe.config.enchant.channelingWaterCheck")
		    @Config.Comment("Prevents Lightning if the target is in Water")
		    public boolean waterCheck = true;
			
		    @Config.LangKey("oe.config.enchant.channelingLavaCheck")
		    @Config.Comment("Prevents Lightning if the target is in Lava")
		    public boolean lavaCheck = true;
			
		    @Config.LangKey("oe.config.enchant.channelingInvert")
		    @Config.Comment("Inverts the Channeling Whitelist into a Blacklist")
		    public boolean invertLightning = false;
			
			@Config.LangKey("oe.config.enchant.channelingBlocks")
		    @Config.Comment("Blocks that Channeling Tridents strike Lighting on when hit")
		    public String[] lightningRodWhitelist = {
		            "minecraft:iron_bars"
		    };
			
			@Config.LangKey("oe.config.enchant.channelingRidingBlacklist")
		    @Config.Comment("Prevents Lightning if the target is riding any of these entities")
		    public String[] ridingBlacklist = {
				 	"minecraft:boat",
		            "minecraft:minecart"
		    };
		}
		
		@Config.LangKey("oe.config.enchant.impaling")
		@Config.Comment("Config for Impaling and Water Jet")
	    public configImpaling impaling = new configImpaling();
		
		public static class configImpaling
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.entity.enableImpalingEnchant")
		    @Config.Comment("If the Impaling Enchantment should be enabled.")
		    public boolean enableImpalingEnchant = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableWaterJet")
		    @Config.Comment("Adds the Water Jet enchantment, which functions like Bedrock Edition's Impaling (Bonus damage to wet mobs). (0 = Disabled, 1 = Enabled, 2 = Disable, and make Impaling use this behavior instead.)")
		    public int enableWaterJet = 1;
			
		    @Config.LangKey("oe.config.enchant.impalingDamage")
		    @Config.Comment("Increases Impaling damage by this per level")
		    public float impalingDamage = 2.5F;
			
		    @Config.LangKey("oe.config.enchant.waterJetDamage")
		    @Config.Comment("Increases Water Jet damage by this per level")
		    public float waterJetDamage = 1.0F;
			
			@Config.LangKey("oe.config.enchant.impalingMobs")
		    @Config.Comment("Mobs affected by the Impaling enchantment")
		    public String[] aquaticMobs = {
				 	"minecraft:squid",
		            "minecraft:guardian",
				 	"minecraft:elder_guardian",
				 	"oe:clam",
				 	"oe:cod",
				 	"oe:crab",
				 	"oe:drowned",
				 	"oe:glow_squid",
				 	"oe:lobster",
				 	"oe:pickled",
				 	"oe:pufferfish",
				 	"oe:salmon",
				 	"oe:tropical_fish",
				 	"oe:tropical_slime",
				 	"oe:turtle"
		    };
		}
		
		@Config.LangKey("oe.config.enchant.loyalty")
		@Config.Comment("Config for Loyalty")
	    public configLoyalty loyalty = new configLoyalty();
		
		public static class configLoyalty
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableLoyaltyEnchant")
		    @Config.Comment("If the Loyalty Enchantment should be enabled.")
		    public boolean enableLoyaltyEnchant = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.loyaltyVoidReturn")
		    @Config.Comment("Loyalty Tridents return when in the void")
		    public boolean loyaltyVoidReturn = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.loyaltyVoidReturnLevel")
		    @Config.Comment("Loyalty Tridents return when below this y-level. (Requires void return to be enabled))")
		    public int loyaltyVoidReturnLevel = -15;
		}
		
		@Config.LangKey("oe.config.enchant.mobStomp")
		@Config.Comment("Config for Mob Stomp")
	    public configMobStomp mobStomp = new configMobStomp();
		
		public static class configMobStomp
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableMobStompEnchant")
		    @Config.Comment("If the Mob Stomp Enchantment should be enabled.")
		    public boolean enableMobStompEnchant = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableMobStompArmorStandBoing")
		    @Config.Comment("Allows Mob Stomp to work when landing atop an Armor Stand.")
		    public boolean enableMobStompArmorStandBoing = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableMobStompDurabilityCost")
		    @Config.Comment("Makes Mob Stomp deal 1 durability after a successful use.")
		    public boolean enableMobStompDurabilityCost = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableMobStompOnAnyBoots")
		    @Config.Comment("Allows Mob Stomp to be placed on any Boots. This enchantment was made to be exclusive to the Heavy Boots, so this breaks the intended balance.")
		    public boolean enableMobStompOnAnyBoots = false;
		}
		
		@Config.LangKey("oe.config.enchant.riptide")
		@Config.Comment("Config for Riptide")
	    public configRiptide riptide = new configRiptide();
		
		public static class configRiptide
		{
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.enableRiptideEnchant")
		    @Config.Comment("If the Riptide Enchantment should be enabled.")
		    public boolean enableRiptideEnchant = true;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.riptideSneakThrowing")
		    @Config.Comment("Lets the player throw their Riptide trident by sneaking. The throw speed is multiplied by the Riptide level, making them VERY fast!")
		    public boolean riptideSneakThrowing = false;
			
			@RequiresMcRestart
		    @Config.LangKey("oe.config.enchant.riptideIBroughtMyOwnWaterThankYou")
		    @Config.Comment("Enables the ability to use Riptide by holding a Bucket in your other hand. I think this really breaks the balance of the Enchantment, but I added it if anyone wants it.")
		    public boolean riptideIBroughtMyOwnWaterThankYou = false;
		}
		
		
	}
	
	@Config.LangKey("oe.config.effect")
	@Config.Comment("Config related to Potion Effects")
    public static configEffects effect = new configEffects();
	
	public static class configEffects
	{
		@RequiresMcRestart
		@Config.LangKey("oe.config.effect.descent")
	    public configDescent descent = new configDescent();
		
		public static class configDescent
		{
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.effect.descentFallPull")
		    @Config.Comment("How much Descent pulls the player when falling. Is multiplied per amplifier, and the current falling speed.")
		    public double descentFallPull = 0.05;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.effect.descentWaterPull")
		    @Config.Comment("How much Descent pulls the player when in water. Is multiplied per amplifier, and the current sinking speed.")
		    public double descentWaterPull = 0.05;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.effect.descentAqAcWaterPull")
		    @Config.Comment("How much Descent pulls the player when in water, WITH Aqua Acrobatics installed. Uses a different formula, but will use the original if set to 0.")
		    public double descentAqAcWaterPull = 0.07;
		    
		    @Config.LangKey("oe.config.effect.descentSlimeFix")
		    @Config.Comment("Fixes an odd bug where slime blocks led to infinite momentum building. I made it a config option because it's funny.")
		    public boolean descentSlimeFix = true;
	    }
	}
	
	
	@Config.LangKey("oe.config.vanillaTweak")
	@Config.Comment("Config for any direct tweaks or changes to Vanilla content")
    public static configVanillaTweak vanillaTweak = new configVanillaTweak();
	
	public static class configVanillaTweak
	{
		@RequiresMcRestart
		@Config.LangKey("oe.config.vanillaTweak.drownConverting")
	    public configDrownConverting drownConverting = new configDrownConverting();
		
		public static class configDrownConverting
		{
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.enableDrownConverting")
		    @Config.Comment("Enables Drown Converting.")
		    public boolean enableDrownConverting = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.drownConversionsList")
		    @Config.Comment("A list of which mobs convert into what, when Drown Converting. If multiple entries exist for the same mob, only the first in the list will be used!")
		    public String[] drownConversionsList =
			{
		    	"minecraft:zombie=oe:drowned",
			 	"minecraft:husk=minecraft:zombie"
		    };
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.enableDrownParticles")
		    @Config.Comment("Adds glowy particles to show when a mob is currently converting.")
		    public boolean enableDrownParticles = true;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.vanillaTweak.waterBonemeal")
	    public configWaterBonemeal waterBonemeal = new configWaterBonemeal();
		
		public static class configWaterBonemeal
		{
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.enableWaterBonemeal")
		    @Config.Comment("Enables Underwater Bonemealing.")
		    public boolean enableWaterBonemeal = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.waterBonemealCoralChance")
		    @Config.Comment("The Coral chance to be placed if it passes the waterBonemealCoralGen check. Else, places Seagrass. 1 / this number.")
		    @Config.RangeInt(min = 0, max = 9999)
		    public int waterBonemealCoralChance = 5;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.waterBonemealCoralGen")
		    @Config.Comment("Makes Coral generate when using underwater bonemeal near Coral Blocks. (0 = Disable, 1 = Generate only on top, 2 = Generate around any side)")
		    @Config.RangeInt(min = 0, max = 2)
		    public int waterBonemealCoralGen = 2;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.vanillaTweak.squidInking")
	    public configSquidInking squidInking = new configSquidInking();
		
		public static class configSquidInking
		{
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.enableSquidInking")
		    @Config.Comment("Enables Squid Inking.")
		    public boolean enableSquidInking = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.inkBlindnessLength")
		    @Config.Comment("How long (in seconds) Blindness caused by Squid Ink is given. Set to 0 to disable ink bliness entierly.")
		    @Config.RangeInt(min = 0, max = 9999)
		    public int inkBlindnessLength = 5;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.squidParticleAmount")
		    @Config.Comment("How many particles made each inking.")
		    @Config.RangeInt(min = 0, max = 9999)
		    public int squidParticleAmount = 60;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.babySquidParticleAmount")
		    @Config.Comment("How many particles made each inking, IF the squid is a baby. Baby Squid particles are also smaller.")
		    @Config.RangeInt(min = 0, max = 9999)
		    public int babySquidParticleAmount = 4;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.inkParticleAge")
		    @Config.Comment("The max age of Ink Particles. Use this to make ink stay around longer.")
		    @Config.RangeInt(min = 0, max = 9999)
		    public int inkParticleAge = 20;
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.vanillaTweak.waterMechanics")
	    public configWaterMechanics waterMechanics = new configWaterMechanics();
		
		public static class configWaterMechanics
		{
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.noSwimList")
		    @Config.Comment("Sets mobs that will not swim, but simply sink. This only works for mobs that could have swam before!")
		    public String[] noSwimList =
			{
		    	"minecraft:zombie",
			 	"minecraft:zombie_villager",
			 	"minecraft:zombie_horse",
			 	"minecraft:zombie_pigman",
			 	"minecraft:husk",
			 	"minecraft:skeleton",
			 	"minecraft:skeleton_horse",
			 	"minecraft:stray",
			 	"minecraft:wither_skeleton",
			 	"oe:tropical_slime"
		    };
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.noDrownList")
		    @Config.Comment("Sets mobs to not have their air run low when underwater. ONLY applies when underwater!")
		    public String[] noDrownList =
			{
		    	"minecraft:zombie",
			 	"minecraft:zombie_villager",
			 	"minecraft:zombie_horse",
			 	"minecraft:zombie_pigman",
			 	"minecraft:husk",
			 	"minecraft:skeleton",
			 	"minecraft:skeleton_horse",
			 	"minecraft:stray",
			 	"minecraft:wither_skeleton",
			 	"oe:tropical_slime"
		    };
	    }
		
		@RequiresMcRestart
		@Config.LangKey("oe.config.vanillaTweak.inkSquirting")
	    public configInkSquirting inkSquirting = new configInkSquirting();
		
		public static class configInkSquirting
		{
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.enableInkSquirting")
		    @Config.Comment("Enables the ability to squirt out Ink Sacs.")
		    public boolean enableInkSquirting = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.inkSquirtingDispense")
		    @Config.Comment("Enables the ability for Dispensers to spray ink from Ink Sacs.")
		    public boolean inkSquirtingDispense = true;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.inkSquirtingUserImmune")
		    @Config.Comment("If the player that is squirting the Ink Sac is immune to the effects. Default is false because it is funny.")
		    public boolean inkSquirtingUserImmune = false;
		    
		    @RequiresMcRestart
		    @Config.LangKey("oe.config.vanillaTweak.inkSquirtingCooldown")
		    @Config.Comment("Adds a cooldown between uses of Ink Sacs.")
		    @Config.RangeInt(min = 0, max = 9999)
		    public int inkSquirtingCooldown = 5;
	    }
		
		@Config.LangKey("oe.config.vanillaTweak.waterLighting")
	    @Config.Comment("Alters how much light Water and Flowing Water block. Default water is 3. Automatically disabled as not only do I predict some MASSIVE incompatabilities, but this will require every water block to be updated. Every single one. ")
	    public int waterTweak = 3;
		
		@Config.LangKey("oe.config.vanillaTweak.waterCancelReplace")
	    @Config.Comment("Prevents buckets from being used on blocks that use the Water Material, but don't extend BlockLiquid. This prevents Water buckets from replacing water plants/animals like Coral and Sea Pickles. Might cause some edge case issues, so it's a config option.")
	    public boolean waterCancelReplace = true;
		
		@Config.LangKey("oe.config.vanillaTweak.squidFlop")
	    @Config.Comment("Allows Squids to flop about on land like fish do.")
	    public boolean squidFlop = true;
		
		@Config.LangKey("oe.config.vanillaTweak.squidPush")
	    @Config.Comment("Allows the Player to shift right-click a Squid to push it a bit. Done as a workaround for players who want to help squids, but can't due to their buggy movement.")
	    public boolean squidPush = true;
	}
	
	@Mod.EventBusSubscriber(modid = Main.MOD_ID)
    public static class ConfigSyncHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if(event.getModID().equals(Main.MOD_ID))
            {
                ConfigManager.sync(Main.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}